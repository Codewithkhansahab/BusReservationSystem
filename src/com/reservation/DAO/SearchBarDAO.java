package com.reservation.DAO;

import com.reservation.Model.Booking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchBarDAO {
    static String url = "jdbc:mysql://localhost:3306/BusReservationdb";
    static String user = "root";
    static String password = "lala@123";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    public List<Booking> searchBar(String pattern) throws SQLException {
        List<Booking> newList = new ArrayList<>();
        String sql = "select * from tickets where passenger_name like ?";
        Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, "%" + pattern + "%");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Booking bs = new Booking(
                    rs.getInt("ticket_id"),
                    rs.getString("passenger_name"),
                    rs.getInt("bus_id"),
                    rs.getInt("seat_number"),
                    rs.getString("travel_date"),
                    rs.getString("travel_time"),
                    rs.getDouble("amount"),
                    rs.getString("status")
            );
            newList.add(bs);
        }

        return newList;
    }
}
