package com.reservation.UI;

import com.reservation.DAO.CancelTicketDAO;
import javax.swing.*;
import java.awt.*;

public class CancelTicketUI extends JPanel {
    private JTextField ticketIdField;
    private JLabel statusLabel;

    public CancelTicketUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Title Label
        JLabel titleLabel = new JLabel("Cancel Ticket");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        // Ticket ID Label
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Enter Ticket ID:"), gbc);

        // Ticket ID Text Field
        ticketIdField = new JTextField(15);
        gbc.gridx = 1;
        add(ticketIdField, gbc);

        // Cancel Button
        JButton cancelButton = new JButton("Cancel Ticket");
        cancelButton.setBackground(new Color(231, 76, 60)); // Red Color
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(cancelButton, gbc);

        // Status Label
        statusLabel = new JLabel();
        statusLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        statusLabel.setForeground(Color.RED);
        gbc.gridy = 3;
        add(statusLabel, gbc);

        // Button Action Listener to Delete Ticket
        cancelButton.addActionListener(e -> cancelTicket());
    }

    private void cancelTicket() {
        String ticketIdText = ticketIdField.getText().trim();

        if (ticketIdText.isEmpty()) {
            statusLabel.setText("❌ Please enter a Ticket ID.");
            return;
        }

        try {
            int ticketId = Integer.parseInt(ticketIdText);
            CancelTicketDAO dao = new CancelTicketDAO();
            boolean isCancelled = dao.cancelTicket(ticketId);  // Ensure method name is correct

            if (isCancelled) {
                statusLabel.setText("✅ Ticket canceled successfully!");
                ticketIdField.setText(""); // Clear field
            } else {
                statusLabel.setText("❌ Ticket not found or already canceled.");
            }
        } catch (NumberFormatException e) {
            statusLabel.setText("❌ Invalid Ticket ID. Enter a number.");
        }
    }
}
