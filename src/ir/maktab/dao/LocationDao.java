package ir.maktab.dao;

import ir.maktab.model.Location;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LocationDao extends BaseDao {
    public void save(Location location) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(location);
        transaction.commit();
        session.close();
    }
}
