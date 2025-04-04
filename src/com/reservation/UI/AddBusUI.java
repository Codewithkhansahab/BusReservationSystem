package com.reservation.UI;

import com.reservation.DAO.AddBusDao;
import javax.swing.*;
import java.awt.*;

public class AddBusUI extends JPanel {
    private JTextField busNameField, busNumberField, totalSeatsField, departureTimeField, arrivalTimeField, sourceField, destinationField, fareField;
    private JLabel statusLabel;
    private Color primaryColor = new Color(41, 128, 185); // Blue Theme

    public AddBusUI() {
        setLayout(new BorderLayout(10, 10));
        setOpaque(false);

        // 🟢 Main Panel with Box Layout
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        formPanel.setBackground(Color.WHITE);

        // 🟢 Title
        JLabel titleLabel = new JLabel("➕ Add New Bus", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(primaryColor);
        formPanel.add(titleLabel);
        formPanel.add(Box.createVerticalStrut(10));

        // 🟢 Input Fields (Labels Above Fields)
        busNameField = addLabeledField(formPanel, "🚌 Bus Name:");
        busNumberField = addLabeledField(formPanel, "🔢 Bus Number:");
        totalSeatsField = addLabeledField(formPanel, "🎟 Total Seats:");
        departureTimeField = addLabeledField(formPanel, "⏰ Departure Time:");
        arrivalTimeField = addLabeledField(formPanel, "⏳ Arrival Time:");
        sourceField = addLabeledField(formPanel, "📍 Source:");
        destinationField = addLabeledField(formPanel, "🚏 Destination:");
        fareField = addLabeledField(formPanel, "💰 Fare:");

        // 🟢 Button Panel (Fixing Visibility Issue)
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("✔ Add Bus");
        styleButton(addButton, new Color(39, 174, 96));
        addButton.addActionListener(e -> addBus());

        buttonPanel.add(addButton);
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(buttonPanel); // Ensures button stays visible

        // 🟢 Status Label (Fixed Position)
        statusLabel = new JLabel("", SwingConstants.CENTER);
        statusLabel.setForeground(Color.RED);
        formPanel.add(Box.createVerticalStrut(5));
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

    // 🔹 Button Styling
    private void styleButton(JButton button, Color color) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // 🔹 Add Bus Logic
    private void addBus() {
        String busName = busNameField.getText().trim();
        String busNumber = busNumberField.getText().trim();
        String totalSeats = totalSeatsField.getText().trim();
        String departureTime = departureTimeField.getText().trim();
        String arrivalTime = arrivalTimeField.getText().trim();
        String source = sourceField.getText().trim();
        String destination = destinationField.getText().trim();
        String fare = fareField.getText().trim();

        if (busName.isEmpty() || busNumber.isEmpty() || totalSeats.isEmpty() ||
                departureTime.isEmpty() || arrivalTime.isEmpty() ||
                source.isEmpty() || destination.isEmpty() || fare.isEmpty()) {
            statusLabel.setText("❌ Please fill all fields.");
            return;
        }

        try {
            int seats = Integer.parseInt(totalSeats);
            double fareAmount = Double.parseDouble(fare);

            AddBusDao dao = new AddBusDao();
            boolean isAdded = dao.addBus(busName, busNumber, seats, departureTime, arrivalTime, source, destination);
            if (isAdded) {
                statusLabel.setForeground(new Color(39, 174, 96));
                statusLabel.setText("✅ Bus added successfully!");
                clearFields();
            } else {
                statusLabel.setText("❌ Error adding bus.");
            }
        } catch (NumberFormatException e) {
            statusLabel.setText("❌ Invalid number format.");
        }
    }

    // 🔹 Clear Input Fields
    private void clearFields() {
        busNameField.setText("");
        busNumberField.setText("");
        totalSeatsField.setText("");
        departureTimeField.setText("");
        arrivalTimeField.setText("");
        sourceField.setText("");
        destinationField.setText("");
        fareField.setText("");
    }
}
