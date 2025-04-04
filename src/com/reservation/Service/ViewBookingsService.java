package com.reservation.Service;

import com.reservation.DAO.ViewBookingDAO;
import com.reservation.Model.Booking;

import java.util.List;

public class ViewBookingsService {
    ViewBookingDAO viewBookingDAO;


    public ViewBookingsService(){
        viewBookingDAO = new ViewBookingDAO();
    }

    public List<Booking> findAllBooking(){
        return viewBookingDAO.bookingList();
    }
}
