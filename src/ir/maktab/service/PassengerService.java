package ir.maktab.service;

import ir.maktab.dao.PassengerDao;
import ir.maktab.model.Passenger;

import java.util.List;

public class PassengerService {
    PassengerDao passengerDao = new PassengerDao();

    public void save(Passenger passenger) {
        passengerDao.save(passenger);
    }

    public List<Passenger> findByUsername(String username) {
        return passengerDao.findByUsername(username);
    }
}
