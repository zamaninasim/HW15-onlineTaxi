package ir.maktab.service;

import ir.maktab.dao.LocationDao;
import ir.maktab.model.Location;

public class LocationService {
    LocationDao locationDao = new LocationDao();

    public void save(Location location) {
        locationDao.save(location);
    }
}
