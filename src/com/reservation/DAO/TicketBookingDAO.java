package com.reservation.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TicketBookingDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/BusReservationDB";
    private static final String USER = "root";
    private static final String PASSWORD = "lala@123";

    public static void bookTicket(String passengerName, int busId, int seatNumber, String travelDate, String travelTime, double amount) {
        String query = "INSERT INTO tickets (passenger_name, bus_id, seat_number, travel_date, travel_time, amount) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, passengerName);
            pstmt.setInt(2, busId);
            pstmt.setInt(3, seatNumber);
            pstmt.setString(4, travelDate);
            pstmt.setString(5, travelTime);
            pstmt.setDouble(6, amount);

            int rowsInserted = pstmt.executeUpdate();
            System.out.println(" Book Ticket Successfully ");
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


}

