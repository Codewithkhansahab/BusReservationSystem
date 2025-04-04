package com.reservation.UI;

import javax.swing.*;
import java.awt.*;

public class HomePanelUI extends JPanel {
    public HomePanelUI(String homePage) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // 🔹 Title Panel
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(Color.WHITE);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));

        JLabel titleLabel = new JLabel("🚍 Bus Reservation System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(new Color(52, 152, 219));

        titlePanel.add(titleLabel, BorderLayout.CENTER);
        add(titlePanel, BorderLayout.NORTH);

        // 🔹 Bus Image Panel
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(Color.WHITE);

        ImageIcon busIcon = new ImageIcon(getClass().getResource("/images/img.png"));
        Image img = busIcon.getImage().getScaledInstance(400, 200, Image.SCALE_SMOOTH);
        JLabel busLabel = new JLabel(new ImageIcon(img));
        busLabel.setHorizontalAlignment(SwingConstants.CENTER);

        imagePanel.add(busLabel, BorderLayout.CENTER);
        add(imagePanel, BorderLayout.CENTER);

        // 🔹 Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 20));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 40, 40));
        buttonPanel.setBackground(Color.WHITE);

        JButton bookButton = createStyledButton("🎟️ Book Ticket");
        JButton viewButton = createStyledButton("📄 View Bookings");

        buttonPanel.add(bookButton);
        buttonPanel.add(viewButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // 🔹 Button Actions
        bookButton.addActionListener(e -> DashboardUI.cardLayout.show(DashboardUI.mainPanel, "BookTicket"));
        viewButton.addActionListener(e -> DashboardUI.cardLayout.show(DashboardUI.mainPanel, "ViewTickets"));
    }

    // 🔹 Function to Create Styled Buttons
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(52, 152, 219));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
        button.setBorder(BorderFactory.createLineBorder(new Color(41, 128, 185), 2, true));

        // 🔄 Button Hover Effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(41, 128, 185));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(52, 152, 219));
            }
        });

        return button;
    }
}
