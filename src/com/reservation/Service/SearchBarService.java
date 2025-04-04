package com.reservation.Service;

import com.reservation.DAO.SearchBarDAO;
import com.reservation.Model.Booking;

import java.sql.SQLException;
import java.util.List;

public class SearchBarService {
    SearchBarDAO searchBarDAO;

    public SearchBarService() {
        searchBarDAO = new SearchBarDAO();
    }

    //    public void searchBar(String pattern) throws SQLException {
//        searchBarDAO.searchBar(pattern);
//    }
    public void searchBar(String keyword) throws SQLException {
        List<Booking> results = searchBarDAO.searchBar(keyword);

        if (results.isEmpty()) {
            System.out.println("No bookings found!");
        } else {
            System.out.println("Search Results:");
            for (Booking b : results) {
                System.out.println("Ticket ID: " + b.getTicket_id() + ", Name: " + b.getPassenger_name());
            }
        }
    }
}
