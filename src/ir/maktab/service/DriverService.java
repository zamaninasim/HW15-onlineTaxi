package ir.maktab.service;

import ir.maktab.dao.DriverDao;
import ir.maktab.dto.DriverDto;
import ir.maktab.model.Driver;
import ir.maktab.model.Location;

import java.util.ArrayList;
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

    public List<DriverDto> driversDistanceToOrigin(Location originLocation) {
        List<Driver> all = driverDao.findAll();
        List<DriverDto> distanceDrivers = new ArrayList<>();
        for (Driver driver : all) {
            DriverDto driverDto = new DriverDto();
            driverDto.setUsername(driver.getUserName());
            driverDto.setDistance(Math.sqrt(Math.pow(driver.getLocation().getLatitude() - originLocation.getLatitude(), 2)
                    + Math.pow(driver.getLocation().getLongitude() - originLocation.getLongitude(), 2)));
            distanceDrivers.add(driverDto);
        }
        return distanceDrivers;
    }

    public String findClosestDriver(List<DriverDto> driverDto) {
        String closestDriverUsername = " ";
        Double min = 100.0;
        for (DriverDto d : driverDto) {
            min = d.getDistance();
            closestDriverUsername = d.getUsername();
            if (d.getDistance() < min) {
                min = d.getDistance();
                closestDriverUsername = d.getUsername();
            }
            return closestDriverUsername;
        }
        return null;
    }

    public void update(Driver driver){
        driverDao.update(driver);
    }

}
