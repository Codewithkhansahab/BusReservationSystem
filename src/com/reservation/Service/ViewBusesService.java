package com.reservation.Service;

import com.reservation.DAO.VeiwBusDAO;
import com.reservation.Model.Bus;

import java.util.List;

public class ViewBusesService {
    VeiwBusDAO veiwBusDAO ;
    public ViewBusesService(){
        veiwBusDAO = new VeiwBusDAO();
    }
  public List<Bus> showAllBus(){
        return veiwBusDAO.getAllBuses();
  }
}
