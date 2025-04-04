package com.reservation.DAO;

import com.reservation.Model.Booking;
import com.reservation.Model.Bus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewBookingDAO {
    String url = "jdbc:mysql://localhost:3306/BusReservationdb";
    String user = "root";
    String password = "lala@123";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public List<Booking> bookingList() {
        List<Booking> allBookings = new ArrayList<>();
        String sql = "select * from tickets";
        try {
            Connection con = getConnection();
            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery(sql);
//            System.out.printf("+------------+-----------------+--------+-------------+------------+------------+--------+--------+\n");
//            System.out.printf("| Ticket ID  | Passenger Name  | Bus ID | Seat Number | Travel Date | Travel Time | Amount | Status |\n");
//            System.out.printf("+------------+-----------------+--------+-------------+------------+------------+--------+--------+\n");
            while (rs.next()) {
                Booking bus = new Booking(
                        rs.getInt("ticket_id"),
                        rs.getString("passenger_name"),
                        rs.getInt("bus_id"),
                        rs.getInt("seat_number"),
                        rs.getString("travel_date"),
                        rs.getString("travel_time"),
                        rs.getDouble("amount"),
                        rs.getString("status")
                        );
                allBookings.add(bus);

            }


        } catch (SQLException e) {
            System.out.println("Error during found bookings");
        }


        return allBookings;
    }


}
