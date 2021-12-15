package ir.maktab.dao;

import ir.maktab.model.Passenger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PassengerDao extends BaseDao {

    public void save(Passenger passenger) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(passenger);
        transaction.commit();
        session.close();
    }

    public List<Passenger> findByUsername(String username) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Passenger> query = session.createQuery("FROM Passenger d WHERE d.userName=:usernameValue");
        query.setParameter("usernameValue", username);
        List<Passenger> resultList = query.getResultList();
        transaction.commit();
        session.close();
        return resultList;
    }

    public List<Passenger> findAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Passenger> query = session.createQuery("FROM Passenger ");
        List<Passenger> resultList = query.getResultList();
        transaction.commit();
        session.close();
        return resultList;
    }

    public void update(Passenger passenger) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(passenger);
        transaction.commit();
        session.close();
    }
}
