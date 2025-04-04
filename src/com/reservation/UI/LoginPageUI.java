package com.reservation.UI;

import com.reservation.Service.UserService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class LoginPageUI extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnRegister, btnToggleMode;
    private UserService userService;
    private boolean isDarkMode = true;

    public LoginPageUI() {
        userService = new UserService();

        // 🟢 Window Settings
        setTitle("🚍 Bus Reservation - Login");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // 🟢 Main Panel with Dark Mode Support
        JPanel mainPanel = createMainPanel();

        // 🟢 Login Card
        JPanel card = createLoginCard();

        // 🟢 Adding Components to Main Panel
        mainPanel.add(card);
        add(mainPanel);
        setVisible(true);
    }

    // 🟢 Create Main Panel
    private JPanel createMainPanel() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(isDarkMode ? new Color(34, 40, 49) : new Color(240, 240, 240));
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new GridBagLayout());
        return panel;
    }

    // 🟢 Create Login Card
    private JPanel createLoginCard() {
        JPanel card = new JPanel(new GridBagLayout());
        card.setPreferredSize(new Dimension(350, 300));
        card.setBackground(new Color(255, 255, 255, 80)); // Glass Effect
        card.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 🟢 Title
        JLabel lblTitle = new JLabel("🚌 Bus Reservation");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setForeground(isDarkMode ? Color.WHITE : Color.BLACK);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        // 🟢 Username Field
        txtUsername = new JTextField(15);
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 14));
        txtUsername.setBorder(BorderFactory.createCompoundBorder(
                txtUsername.getBorder(), BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        // 🟢 Password Field
        txtPassword = new JPasswordField(15);
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        txtPassword.setBorder(BorderFactory.createCompoundBorder(
                txtPassword.getBorder(), BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        // 🟢 Buttons
        btnLogin = createStyledButton("Login", new Color(41, 128, 185));
        btnRegister = createStyledButton("Register", new Color(39, 174, 96));
        btnToggleMode = createToggleButton();

        // 🟢 Action Listeners
        btnLogin.addActionListener(e -> handleLogin());
        btnRegister.addActionListener(e -> handleRegister());

        // 🟢 Adding Components to Card
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; card.add(lblTitle, gbc);
        gbc.gridy = 1; gbc.gridwidth = 1; card.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1; card.add(txtUsername, gbc);
        gbc.gridx = 0; gbc.gridy = 2; card.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1; card.add(txtPassword, gbc);
        gbc.gridx = 1; gbc.gridy = 3; card.add(btnLogin, gbc);
        gbc.gridy = 4; card.add(btnRegister, gbc);
        gbc.gridy = 5; card.add(btnToggleMode, gbc);

        return card;
    }

    // 🟢 Create Styled Buttons
    private JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    // 🟢 Create Dark Mode Toggle Button
    private JButton createToggleButton() {
        JButton button = new JButton("🌙");
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(Color.LIGHT_GRAY);
        button.setForeground(Color.BLACK);
        button.setBorderPainted(false);
        button.addActionListener(e -> toggleMode());
        return button;
    }

    // 🟢 Toggle Dark Mode
    private void toggleMode() {
        isDarkMode = !isDarkMode;
        getContentPane().repaint();
    }

    // 🟢 Handle Login
    private void handleLogin() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();
        try {
            if (userService.loginUser(username, password)) {
                JOptionPane.showMessageDialog(this, "✅ Login Successful!");
                openDashboard(); // ✅ Open Dashboard
            } else {
                JOptionPane.showMessageDialog(this, "❌ Invalid Username or Password!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "⚠️ Database Error!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // 🟢 Open Dashboard and Close Login Page
    private void openDashboard() {
        new DashboardUI();
        dispose(); // Close Login Window
    }

    // 🟢 Handle Register
    private void handleRegister() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();
        try {
            if (userService.registerUser(username, password)) {
                JOptionPane.showMessageDialog(this, "✅ Registration Successful!");
            } else {
                JOptionPane.showMessageDialog(this, "❌ Registration Failed!");
                JOptionPane.showMessageDialog(this,"Username or Password must have at least 4 characters.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "⚠️ Database Error!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

//    // 🟢 Main Method
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(LoginPageUI::new);
//    }
}
