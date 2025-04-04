package com.reservation.UI;

import com.reservation.DAO.TicketBookingDAO;
import javax.swing.*;
import java.awt.*;

public class BookTicketUI extends JPanel {
    private JTextField nameField, seatField, dateField, timeField, amountField;
    private JComboBox<String> busDropdown;
    private JLabel statusLabel;
    private Color primaryColor = new Color(41, 128, 185);  // Blue Theme

    public BookTicketUI() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);

        // 🟢 Main Panel with BoxLayout
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        formPanel.setBackground(Color.WHITE);

        // 🟢 Title Label
        JLabel titleLabel = new JLabel("🎟 Book a Ticket", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(primaryColor);
        formPanel.add(titleLabel);
        formPanel.add(Box.createVerticalStrut(10));

        // 🟢 Input Fields (Labels Above Fields)
        nameField = addLabeledField(formPanel, "👤 Passenger Name:");
        busDropdown = addDropdownField(formPanel, "🚌 Select Bus:", new String[]{"Bus 101", "Bus 102", "Bus 103"});
        seatField = addLabeledField(formPanel, "💺 Seat Number:");
        dateField = addLabeledField(formPanel, "📅 Travel Date (YYYY-MM-DD):");
        timeField = addLabeledField(formPanel, "⏰ Travel Time (HH:MM:SS):");
        amountField = addLabeledField(formPanel, "💰 Amount:");

        // 🟢 Button Panel
        JPanel buttonPanel = new JPanel();
        JButton bookButton = new JButton("✔ Book Ticket");
        styleButton(bookButton, new Color(39, 174, 96));
        bookButton.addActionListener(e -> bookTicket());
        buttonPanel.add(bookButton);

        // 🟢 Status Label
        statusLabel = new JLabel("", SwingConstants.CENTER);
        statusLabel.setForeground(Color.RED);

        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(buttonPanel);
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(statusLabel);

        add(formPanel, BorderLayout.CENTER);
    }

    // 🔹 Helper Method to Add Labels Above Fields
    private JTextField addLabeledField(JPanel panel, String labelText) {
        JPanel fieldPanel = new JPanel(new BorderLayout(5, 5));
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField textField = new JTextField(15);

        fieldPanel.add(label, BorderLayout.NORTH);
        fieldPanel.add(textField, BorderLayout.CENTER);
        panel.add(fieldPanel);
        panel.add(Box.createVerticalStrut(5));

        return textField;
    }

    // 🔹 Helper Method to Create Dropdowns
    private JComboBox<String> addDropdownField(JPanel panel, String labelText, String[] options) {
        JPanel fieldPanel = new JPanel(new BorderLayout(5, 5));
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 14));

        fieldPanel.add(label, BorderLayout.NORTH);
        fieldPanel.add(comboBox, BorderLayout.CENTER);
        panel.add(fieldPanel);
        panel.add(Box.createVerticalStrut(5));

        return comboBox;
    }

    // 🔹 Button Styling
    private void styleButton(JButton button, Color color) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // 🔹 Book Ticket Logic
    private void bookTicket() {
        try {
            String name = nameField.getText().trim();
            int busId = busDropdown.getSelectedIndex() + 1;
            int seat = Integer.parseInt(seatField.getText().trim());
            String date = dateField.getText().trim();
            String time = timeField.getText().trim();
            double amount = Double.parseDouble(amountField.getText().trim());

            //boolean success = TicketBookingDAO.bookTicket(name, busId, seat, date, time, amount);
            boolean success = true;  // Simulated success
            if (success) {
                statusLabel.setForeground(new Color(39, 174, 96));
                statusLabel.setText("✅ Ticket Booked Successfully!");
                JOptionPane.showMessageDialog(this, "🎟 Ticket Booked Successfully!");
                clearFields();
            } else {
                statusLabel.setText("❌ Booking Failed!");
            }
        } catch (NumberFormatException e) {
            statusLabel.setText("❌ Invalid input. Please check values.");
        }
    }

    // 🔹 Clear Input Fields
    private void clearFields() {
        nameField.setText("");
        seatField.setText("");
        dateField.setText("");
        timeField.setText("");
        amountField.setText("");
    }
}
