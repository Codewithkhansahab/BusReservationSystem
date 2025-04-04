package com.reservation.Service;

import com.reservation.DAO.TicketBookingDAO;

public class BookTicketService {
    TicketBookingDAO ticketBookingDAO;
    public BookTicketService(){
        ticketBookingDAO = new TicketBookingDAO();
    }
    public void bookTicket(String passengerName, int busId, int seatNumber, String travelDate, String travelTime, double amount){
        ticketBookingDAO.bookTicket(passengerName,busId,seatNumber,travelDate,travelTime,amount);
    }
}
