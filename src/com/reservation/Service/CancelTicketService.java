package com.reservation.Service;

import com.reservation.DAO.CancelTicketDAO;

public class CancelTicketService {
    CancelTicketDAO cancelTicketDAO;
    public CancelTicketService(){
        cancelTicketDAO = new CancelTicketDAO();
    }
    public void cancelTicket(int ticketId1){
        cancelTicketDAO.ticketExists(ticketId1);
        cancelTicketDAO.cancelTicket(ticketId1);
    }

}
