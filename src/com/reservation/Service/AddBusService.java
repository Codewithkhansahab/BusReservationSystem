package com.reservation.Service;

import com.reservation.DAO.AddBusDao;

public class AddBusService {
    AddBusDao addBusDao;
    public AddBusService(){
        addBusDao = new AddBusDao();
    }
    public void AddBus(String busName, String busNumber, int totalSeats, String departureTime, String arrivalTime, String source,String destination){

        addBusDao.addBus(busName,busNumber,totalSeats,departureTime,arrivalTime,source,destination);

    }
}
