package ir.maktab.dao;

import ir.maktab.model.Passenger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PassengerDao extends BaseDao {

    public void save(Passenger passenger) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(passenger);
        transaction.commit();
        session.close();
    }
}
