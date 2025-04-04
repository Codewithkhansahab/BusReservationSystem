package com.reservation.Service;

import com.reservation.DAO.PaymentDAO;

public class PaymentService {
    PaymentDAO paymentDAO;
    public PaymentService(){
        paymentDAO = new PaymentDAO();
    }

    public void addPayment(String cardNumber,String cardHolder, int cvv,int amount){
        paymentDAO.addPayment(cardNumber, cardHolder, cvv, amount);
    }
}
