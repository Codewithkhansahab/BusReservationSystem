package com.reservation.Model;

public class Bus {
    private int id;
    private String busName;
    private String busNumber;
    private int totalSeat;
    private String departureTime;
    private String arrivalTime;
    private String source;
    private String destination;

    public Bus(int id,String busName,String busNumber,int totalSeat,String departureTime,String arrivalTime,String source,String destination){
        this.id= Integer.parseInt(String.valueOf(id));
        this.busName=busName;
        this.busNumber=busNumber;
        this.totalSeat= Integer.parseInt(String.valueOf(totalSeat));
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;
        this.source=source;
        this.destination= String.valueOf(destination);

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }


    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", busName='" + busName + '\'' +
                ", busNumber='" + busNumber + '\'' +
                ", totalSeat=" + totalSeat +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}

