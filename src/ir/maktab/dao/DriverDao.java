package ir.maktab.dao;

import ir.maktab.model.Driver;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DriverDao extends BaseDao {

    public void save(Driver driver) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(driver);
        transaction.commit();
        session.close();
    }
}
