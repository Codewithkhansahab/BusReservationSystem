package com.reservation.UI;

import com.reservation.DAO.ViewBookingDAO;
import com.reservation.Model.Booking;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.List;

public class ViewBookings extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private ViewBookingDAO bookingDAO;

    public ViewBookings() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        bookingDAO = new ViewBookingDAO();

        // 🔹 Title Label
        JLabel titleLabel = new JLabel("📜 Your Bookings", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(new Color(52, 152, 219));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        add(titleLabel, BorderLayout.NORTH);

        // 🔹 Table Model
        model = new DefaultTableModel(new String[]{"Ticket ID", "Passenger Name", "Bus ID", "Seat Number", "Travel Date", "Travel Time", "Amount", "Status"}, 0);
        table = new JTable(model);
        table.setRowSorter(new TableRowSorter<>(model));
        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 14));

        // 🔹 Table Header Customization
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Arial", Font.BOLD, 14));
        tableHeader.setBackground(new Color(52, 152, 219));
        tableHeader.setForeground(Color.WHITE);

        // 🔹 Scroll Pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        add(scrollPane, BorderLayout.CENTER);

        // 🔹 Load Data
        loadBooking();
    }

    // 🔹 Method to Load Booking Data
    public void loadBooking() {
        List<Booking> bookings = bookingDAO.bookingList();
        model.setRowCount(0); // Clear previous data

        if (bookings == null || bookings.isEmpty()) {
            JLabel noDataLabel = new JLabel("🚫 No bookings found!", SwingConstants.CENTER);
            noDataLabel.setFont(new Font("Arial", Font.ITALIC, 16));
            noDataLabel.setForeground(Color.GRAY);
            add(noDataLabel, BorderLayout.CENTER);
            revalidate();
            repaint();
            return;
        }

        for (Booking booking : bookings) {
            model.addRow(new Object[]{
                    booking.getTicket_id(), booking.getPassenger_name(), booking.getBus_id(),
                    booking.getSeatNumber(), booking.getTravel_date(), booking.getTravet_time(),
                    booking.getAmount(), booking.getStatus()
            });
        }
    }
}
