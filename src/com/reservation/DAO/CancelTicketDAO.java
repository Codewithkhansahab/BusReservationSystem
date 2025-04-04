package com.reservation.DAO;

import java.sql.*;

public class CancelTicketDAO {
    String url = "jdbc:mysql://localhost:3306/BusReservationdb";
    String user = "root";
    String password = "lala@123";
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    public boolean ticketExists(int ticketId1) {
        String checkQuery = "SELECT * FROM tickets WHERE ticket_id = ?";
        try {
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(checkQuery);

            stmt.setInt(1, ticketId1);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("✅ Ticket Found: " + ticketId1);

            } else {
                System.out.println("❌ Ticket NOT Found: " + ticketId1);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }

        // Delete Ticket from Database
        public boolean cancelTicket (int ticketId){
//

            String deleteQuery = "DELETE FROM tickets WHERE ticket_id = ?";
            try {
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(deleteQuery);
                stmt.setInt(1, ticketId);
               // System.out.println("🛠 Executing Query: " + stmt.toString());

                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("✅ Ticket deleted successfully!");
                    return true;
                } else {
                    System.out.println("❌ Ticket deletion failed.");
                    return false;
                }

            }
            catch (SQLException e) {
                System.out.println("Error");
                return false;
            }

        }
    }

