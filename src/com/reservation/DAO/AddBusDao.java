package com.reservation.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBusDao {
    String url = "jdbc:mysql://localhost:3306/BusReservationdb";
    String user = "root";
    String password = "lala@123";
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    public boolean addBus(String busName, String busNumber, int totalSeats, String departureTime, String arrivalTime, String source,String destination){
        String sql = "insert into buses (bus_name,bus_number,total_seat,departure_time,arrival_time,source,destination) values (?,?,?,?,?,?,?)";
        try{
            Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, busName);
            pst.setString(2, busNumber);
            pst.setInt(3, totalSeats);
            pst.setString(4, departureTime);
            pst.setString(5, arrivalTime);
            pst.setString(6, source);
            pst.setString(7, destination);

            int rowInsert = pst.executeUpdate();
            if (rowInsert>0){
                System.out.println("Bus Added Successfully !!! ");
                return true;
            }
            else {
                System.out.println("Enter Correct Entry !!!");
                return false;
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       // return true;
    }
}
