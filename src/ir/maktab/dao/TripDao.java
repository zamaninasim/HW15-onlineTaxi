package ir.maktab.dao;

import ir.maktab.model.Driver;
import ir.maktab.model.Passenger;
import ir.maktab.model.Trip;
import ir.maktab.model.enums.PaymentType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TripDao extends BaseDao {
    public void save(Trip trip) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(trip);
        transaction.commit();
        session.close();
    }

    public Trip findTripByDrive(Driver driver) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Trip> query = session.createQuery("FROM Trip t WHERE t.driver=:driverValue AND t.tripStatus='PROCESSING'");
        query.setParameter("driverValue", driver);
        List<Trip> resultList = query.getResultList();
        Trip trip = resultList.get(0);
        transaction.commit();
        session.close();
        return trip;
    }

    public void update(Trip trip) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(trip);
        transaction.commit();
        session.close();
    }

}
