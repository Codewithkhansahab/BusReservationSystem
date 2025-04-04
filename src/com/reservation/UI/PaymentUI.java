package com.reservation.UI;
import javax.swing.*;
import java.awt.*;
import com.reservation.DAO.PaymentDAO;

public class PaymentUI extends JPanel {
    private JTextField cardField, nameField, amountField;
    private JPasswordField cvvField;
    private JLabel statusLabel;
    private Color primaryColor = new Color(52, 152, 219);  // Blue Theme

    public PaymentUI() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // 🟢 Title Label
        JLabel titleLabel = new JLabel("💳 Make a Secure Payment", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(primaryColor);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(titleLabel, BorderLayout.NORTH);

        // 🟢 Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        formPanel.setBackground(Color.WHITE);

        // Input Fields
        cardField = addLabeledField(formPanel, "💳 Card Number:");
        nameField = addLabeledField(formPanel, "👤 Cardholder Name:");
        cvvField = addPasswordField(formPanel, "🔒 CVV:");
        amountField = addLabeledField(formPanel, "💰 Amount:");

        // 🟢 Pay Button
        JPanel buttonPanel = new JPanel();
        JButton payButton = new JButton("✔ Pay Now");
        styleButton(payButton, new Color(39, 174, 96));
        payButton.addActionListener(e -> processPayment());
        buttonPanel.add(payButton);
        buttonPanel.setBackground(Color.WHITE);

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
        fieldPanel.setBackground(Color.WHITE);
        panel.add(fieldPanel);
        panel.add(Box.createVerticalStrut(8));

        return textField;
    }

    // 🔹 Helper Method for Password Field (CVV)
    private JPasswordField addPasswordField(JPanel panel, String labelText) {
        JPanel fieldPanel = new JPanel(new BorderLayout(5, 5));
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        JPasswordField passwordField = new JPasswordField(15);

        fieldPanel.add(label, BorderLayout.NORTH);
        fieldPanel.add(passwordField, BorderLayout.CENTER);
        fieldPanel.setBackground(Color.WHITE);
        panel.add(fieldPanel);
        panel.add(Box.createVerticalStrut(8));

        return passwordField;
    }

    // 🔹 Button Styling
    private void styleButton(JButton button, Color color) {
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // 🔹 Process Payment Logic
    private void processPayment() {
        try {
            String cardNumber = cardField.getText().trim();
            String cardholderName = nameField.getText().trim();
            String cvv = new String(cvvField.getPassword()).trim();
            double amount = Double.parseDouble(amountField.getText().trim());

            boolean success = PaymentDAO.addPayment(cardNumber, cardholderName, Integer.parseInt(cvv), amount);

            if (success) {
                statusLabel.setForeground(new Color(39, 174, 96));
                statusLabel.setText("✅ Payment Successful!");
                JOptionPane.showMessageDialog(this, "🎉 Payment Completed Successfully!");
                clearFields();
            } else {
                statusLabel.setText("❌ Payment Failed! Please try again.");
            }
        } catch (NumberFormatException e) {
            statusLabel.setText("❌ Invalid input. Please check values.");
        }
    }

    // 🔹 Clear Input Fields
    private void clearFields() {
        cardField.setText("");
        nameField.setText("");
        cvvField.setText("");
        amountField.setText("");
    }
}
