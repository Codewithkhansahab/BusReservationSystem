package com.reservation.DAO;
import java.sql.*;

public class UserDAO {
    String url = "jdbc:mysql://127.0.0.1:3306/BusReservation";
    String user = "root";
    String password = "lala@123";
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }




        // Validate user login
        public boolean validateUser(String username, String password) throws SQLException {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            Connection con = getConnection();
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password); // Compare hashed password
                try (ResultSet rs = pstmt.executeQuery()) {
                    return rs.next();
                }
            } catch (SQLException e) {
                System.err.println("Error during login: " + e.getMessage());
            }
            return false;
        }

        // Register a new user with hashed password
        public boolean registerUser(String username, String password) throws SQLException {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

            try {
                Connection con = getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, username);
                pstmt.setString(2, password); // Store hashed password
                return pstmt.executeUpdate() > 0;
            } catch (SQLException e) {
                System.err.println("Error during registration: " + e.getMessage());
            }
            return false;
        }
    }



