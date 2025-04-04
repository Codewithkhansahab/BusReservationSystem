package com.reservation.Model;

public class Route {
    private int id;
    private String source;
    private String destination;
    private int busId;

    public Route(int id,String source,String destination,int busId){
        this.id=id;
        this.source=source;
        this.destination=destination;
        this.busId=busId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }
}
