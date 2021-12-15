package ir.maktab.dao;

import ir.maktab.model.Driver;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DriverDao extends BaseDao {

    public void save(Driver driver) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(driver);
        transaction.commit();
        session.close();
    }

    public List<Driver> findByUsername(String username) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Driver> query = session.createQuery("FROM Driver d WHERE d.userName=:usernameValue");
        query.setParameter("usernameValue", username);
        List<Driver> resultList = query.getResultList();
        transaction.commit();
        session.close();
        return resultList;
    }

    public List<Driver> findAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Driver> query = session.createQuery("FROM Driver");
        List<Driver> resultList = query.getResultList();
        transaction.commit();
        session.close();
        return resultList;
    }

    public void update(Driver driver) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(driver);
        transaction.commit();
        session.close();
    }
}
