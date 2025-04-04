package com.reservation.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RouteDAO {
    String url = "jdbc:mysql://127.0.0.1:3306/BusReservation";
    String user = "root";
    String password = "lala@123";
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    public void addRoute(String source, String destination, int bus_id){
//        String sql = "insert into routes (source,destination,bus_id) values (?,?,?)";
//        try {
//
//        }
//        }
    }
}
