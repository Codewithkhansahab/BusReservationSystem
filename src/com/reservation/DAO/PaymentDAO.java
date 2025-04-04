package com.reservation.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDAO {
    static String url = "jdbc:mysql://localhost:3306/BusReservationdb";
    static String user = "root";
    static String password = "lala@123";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    public static boolean addPayment(String cardNumber, String cardHolder, int cvv, double amount){

        String sql = "insert into Payment (card_number,cardholder_name,cvv,amount) values (?,?,?,?)";
        try{
            Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,cardNumber);
            pst.setString(2,cardHolder);
            pst.setString(3, String.valueOf(cvv));
            pst.setDouble(4,amount);

            int rs = pst.executeUpdate();
            if(rs>0){
                System.out.println("payment Successful");
            }
        } catch (SQLException e) {
            System.out.println("Error during Payment !!!");
        }
        return true;
    }
}
