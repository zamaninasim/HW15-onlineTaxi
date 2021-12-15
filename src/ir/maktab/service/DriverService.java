package ir.maktab.service;

import ir.maktab.dao.DriverDao;
import ir.maktab.model.Driver;

import java.util.List;

public class DriverService {
    DriverDao driverDao = new DriverDao();

    public void save(Driver driver) {
        driverDao.save(driver);
    }

    public List<Driver> findByUsername(String username) {
        return driverDao.findByUsername(username);
    }

    public List<Driver> findAll() {
        return driverDao.findAll();
    }
}
