package passenger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import storage.hibernate.HibernateUtil;

import java.sql.SQLException;

public class HibernatePassengerDAOService implements IPassengerDAOService {
    @Override
    public void create(Passenger passenger) throws SQLException {
        final Session session = HibernateUtil.getINSTANCE().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(passenger);
        transaction.commit();
        session.close();
    }

    @Override
    public Passenger getByPassport(String passport) throws SQLException {
        try (final Session session = HibernateUtil.getINSTANCE().getSessionFactory().openSession()) {
            Query<Passenger> query = session.createQuery("from Passenger where passport = :passport", Passenger.class);
            query.setParameter("passport", passport);
            return query.list().stream().findFirst().orElse(null);
        }
    }
}
