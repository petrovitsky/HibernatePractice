package ticket;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import planet.Planet;
import storage.hibernate.HibernateUtil;

import java.sql.SQLException;

public class HibernateTicketDAOService implements ITicketDAOService {
    @Override
    public long create(Ticket ticket) throws SQLException {
        final Session session = HibernateUtil.getINSTANCE().getSessionFactory().openSession();
        final Transaction transaction = session.beginTransaction();
        session.persist(ticket);
        transaction.commit();
        session.close();
        return ticket.getId();
    }

    @Override
    public long getTicketCountToPlanet(Planet planet) throws SQLException {
        //HQL
//        Session session = HibernateUtil.getINSTANCE().getSessionFactory().openSession();
//        final Query<Long> query = session.createQuery("select count(id) from Ticket t where t.to = :to", Long.class);
//        query.setParameter("to", planet);
//        session.close();
//        return query.getSingleResult();

        //Native query SQL
        try (Session session = HibernateUtil.getINSTANCE().getSessionFactory().openSession()) {
            final NativeQuery<Long> nativeQuery = session.createNativeQuery("SELECT count(*) FROM ticket WHERE to_planet = ? ", Long.class);
            nativeQuery.setParameter(1, planet.name());
            return nativeQuery.getSingleResult();
        }
    }
}
