package ir.maktab.service;

import ir.maktab.dao.TripDao;
import ir.maktab.model.Driver;
import ir.maktab.model.Location;
import ir.maktab.model.Trip;

public class TripService {
    TripDao tripDao = new TripDao();

    public void save(Trip trip) {
        tripDao.save(trip);
    }

    public int calculateThePrice(Location origin, Location destination) {
        Double distance = Math.sqrt(Math.pow((origin.getLatitude() - destination.getLatitude()), 2)
                + Math.pow((origin.getLongitude() - destination.getLongitude()), 2));
        int tripsPrice = (int) Math.round(distance * 1000);
        return tripsPrice;
    }

    public Trip findTripByDrive(Driver driver) {
        return tripDao.findTripByDrive(driver);
    }

    public void update(Trip trip) {
        tripDao.update(trip);
    }
}
