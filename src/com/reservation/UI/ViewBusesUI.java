package com.reservation.UI;

import com.reservation.DAO.VeiwBusDAO;
import com.reservation.Model.Bus;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ViewBusesUI extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private VeiwBusDAO busDAO;

    public ViewBusesUI() {
        busDAO = new VeiwBusDAO();
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // 🔹 Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("🚌 Available Buses", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(new Color(52, 152, 219));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        titlePanel.add(titleLabel, BorderLayout.CENTER);

        // 🔄 Refresh Button
        JButton refreshButton = new JButton("🔄 Refresh");
        refreshButton.setBackground(new Color(52, 152, 219));
        refreshButton.setForeground(Color.WHITE);
        refreshButton.setFont(new Font("Arial", Font.BOLD, 14));
        refreshButton.setFocusPainted(false);
        refreshButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        refreshButton.addActionListener(e -> loadBusData());
        titlePanel.add(refreshButton, BorderLayout.EAST);

        add(titlePanel, BorderLayout.NORTH);

        // 🔹 Table Setup
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Bus ID", "Bus Name", "Source", "Destination", "Departure", "Arrival", "Seats", "Bus Number"});
        table = new JTable(model);
        table.setRowHeight(30);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(52, 152, 219));
        table.getTableHeader().setForeground(Color.WHITE);

        // Hover effect
        table.setSelectionBackground(new Color(230, 247, 255));
        table.setSelectionForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        add(scrollPane, BorderLayout.CENTER);

        // 🔹 Load Data Initially
        loadBusData();
    }

    private void loadBusData() {
        List<Bus> buses = busDAO.getAllBuses();
        model.setRowCount(0); // Clear previous data

        for (Bus bus : buses) {
            model.addRow(new Object[]{
                    bus.getId(),          // ✅ Correct Bus ID
                    bus.getBusName(),
                    bus.getSource(),
                    bus.getDestination(),
                    bus.getDepartureTime(),
                    bus.getArrivalTime(),
                    bus.getTotalSeat(),
                    bus.getBusNumber()        // ✅ Correct Fare
            });
        }
    }
}
