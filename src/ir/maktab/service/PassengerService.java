package ir.maktab.service;

import ir.maktab.dao.PassengerDao;
import ir.maktab.model.Passenger;

public class PassengerService {
    PassengerDao passengerDao = new PassengerDao();

    public void save(Passenger passenger) {
        passengerDao.save(passenger);
    }
}
