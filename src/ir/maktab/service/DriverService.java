package ir.maktab.service;

import ir.maktab.dao.DriverDao;
import ir.maktab.model.Driver;

public class DriverService {
    DriverDao driverDao = new DriverDao();

    public void save(Driver driver) {
        driverDao.save(driver);
    }
}
