package com.reservation.UI;

import javax.swing.*;
import java.awt.*;

public class DashboardUI extends JFrame {
    static JPanel mainPanel;
    static CardLayout cardLayout;

    public DashboardUI() {
        // Frame Settings
        setTitle("Bus Reservation System - Dashboard");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel for Switching Screens
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add different UI panels
        mainPanel.add(new HomePanelUI("HomePage"), "Home");
        mainPanel.add(new BookTicketUI(), "BookTicket");
        mainPanel.add(new CancelTicketUI(), "CancelTicket");
        mainPanel.add(new PaymentUI(), "Payment");
        mainPanel.add(new AddBusUI(), "AddBuses");
        mainPanel.add(new ViewBusesUI(), "View Buses");
        mainPanel.add(new ViewBookings(), "View Bookings");

        // Sidebar Panel for Buttons
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new GridLayout(8, 1, 10, 10)); // 8 Buttons
        sidePanel.setBackground(new Color(44, 62, 80));

        // Create Buttons for Navigation
        sidePanel.add(createNavButton("🏠 Home", "Home"));
        sidePanel.add(createNavButton("🎟️ Book Ticket", "BookTicket"));
        sidePanel.add(createNavButton("❌ Cancel Ticket", "CancelTicket"));
        sidePanel.add(createNavButton("🚌 View Buses", "View Buses"));
        sidePanel.add(createNavButton("➕ Add Buses", "AddBuses"));
        sidePanel.add(createNavButton("💰 Payment", "Payment"));

        // ✅ FIXED: Logout Button Working
        JButton btnLogout = createNavButton("🚪 Logout", "Logout");
        btnLogout.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                dispose();  // ✅ Close Dashboard
                new LoginPageUI();  // ✅ Open Login Page
            }
        });

        sidePanel.add(btnLogout); // ✅ Added Logout Button to Sidebar

        // Add Components to Frame
        add(sidePanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        // Show Home Page First
        cardLayout.show(mainPanel, "Home");

        setVisible(true);
    }

    // Create Navigation Button
    private JButton createNavButton(String text, String panelName) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(52, 152, 219));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> cardLayout.show(mainPanel, panelName));
        return button;
    }
}
