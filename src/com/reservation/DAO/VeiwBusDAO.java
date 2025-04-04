package com.reservation.DAO;


import com.reservation.Model.Bus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiwBusDAO {
    String url = "jdbc:mysql://localhost:3306/BusReservationdb";
    String user = "root";
    String password = "lala@123";
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    public List<Bus> getAllBuses() {
        List<Bus> busList = new ArrayList<>();
        String sql = "select * from buses ";
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Bus bus = new Bus(
                        rs.getInt("bus_id"),
                        rs.getString("bus_name"),
                        rs.getString("bus_number"),
                        rs.getInt("total_seat"),
                        rs.getString("departure_time"),
                        rs.getString("arrival_time"),
                        rs.getString("source"),
                        rs.getString("destination")
                      //  rs.getInt("fare")
                );
                busList.add(bus);
            }
            return busList;

    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
