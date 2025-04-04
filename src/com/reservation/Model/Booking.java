package com.reservation.Model;

public class Booking {
    private int ticket_id;
    private String passenger_name;
    private int bus_id;
    private int seatNumber;
    private String travel_date;
    private String travet_time;
    private double amount;
    private String status;

    public Booking(int ticket_id, String passenger_name, int bus_id, int seatNumber, String travel_date, String travet_time, double amount, String status) {
        this.ticket_id = ticket_id;
        this.passenger_name=passenger_name;
        this.bus_id=bus_id;
        this.seatNumber=seatNumber;
        this.travel_date=travel_date;
        this.travet_time=travet_time;
        this.amount=amount;
        this.status=status;

    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getPassenger_name() {
        return passenger_name;
    }

    public void setPassenger_name(String passenger_name) {
        this.passenger_name = passenger_name;
    }

    public int getBus_id() {
        return bus_id;
    }

    public void setBus_id(int bus_id) {
        this.bus_id = bus_id;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getTravel_date() {
        return travel_date;
    }

    public void setTravel_date(String travel_date) {
        this.travel_date = travel_date;
    }

    public String getTravet_time() {
        return travet_time;
    }

    public void setTravet_time(String travet_time) {
        this.travet_time = travet_time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

