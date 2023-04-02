package storage.hibernate;

import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import passenger.Passenger;
import storage.DataBaseInitService;
import tests.Person;
import tests.PersonInfo;
import tests.Workplace;
import ticket.Ticket;

import java.util.Arrays;
import java.util.List;

public class HibernateUtil {
    private static final HibernateUtil INSTANCE;

    static {
        INSTANCE = new HibernateUtil();
    }

    @Getter
    private SessionFactory sessionFactory;

    private HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Passenger.class)
                .addAnnotatedClass(Ticket.class)
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(PersonInfo.class)
                .addAnnotatedClass(Workplace.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getINSTANCE() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }

    public static void main(String[] args) {
        //flyway DB migration
        new DataBaseInitService().initDB();


        HibernateUtil hibernateUtil = new HibernateUtil();

        // Get single
//        Session session = hibernateUtil.getSessionFactory().openSession();
//        final Passenger passenger = session.get(Passenger.class, 1l);
//        System.out.println("passenger = " + passenger);
//        session.close();


        // List of passengers
//        Session session = hibernateUtil.getSessionFactory().openSession();
//        List<Passenger> passengerList = session.createQuery("from Passenger", Passenger.class).list();
//        System.out.println("passengerList = " + passengerList);
//        session.close();

        //Add new passenger
//        Session session = hibernateUtil.getSessionFactory().openSession();
//            Transaction transaction = session.beginTransaction();
//                Passenger newPassenger = new Passenger();
//                newPassenger.setName("Mira");
//                newPassenger.setPassport("nl15");
//                session.persist(newPassenger);
//                System.out.println("newPassenger = " + newPassenger);
//            transaction.commit();
//        session.close();

        //List all tickets
//        Session session = hibernateUtil.getSessionFactory().openSession();
//        List<Ticket> tickets = session.createQuery("from Ticket",Ticket.class).list();
//        System.out.println("tickets = " + tickets);
//        session.close();

        // One to one adding
//        Session session = hibernateUtil.getSessionFactory().openSession();
//            final Transaction transaction = session.beginTransaction();
//                Person newPerson = new Person();
//                newPerson.setAddressList(Arrays.asList("AAA", "BBB"));
//                System.err.println("Is persist before persist() ? -  " + session.contains(newPerson));
//                session.persist(newPerson);
//                PersonInfo personInfo = new PersonInfo();
//                personInfo.setName("Eugene");
//                personInfo.setPerson(newPerson);
//                newPerson.setPersonInfo(personInfo);
//                session.persist(newPerson);
//        transaction.commit();
//        System.err.println("Is persist after .commit() ? - " + session.contains(newPerson));
//        session.close();

//        final Session session = hibernateUtil.getSessionFactory().openSession();
//            final Transaction transaction = session.beginTransaction();
//                final Person person = new Person();
//
//                person.setAddressList(List.of("Vinnytsya"));
//                session.persist(person);
//
//                final PersonInfo personInfo = new PersonInfo();
//                personInfo.setName("Vika");
//                personInfo.setPerson(person);
//                person.setPersonInfo(personInfo);
//
//                final Workplace workplace = new Workplace();
//                workplace.setPlace("Non");
//                workplace.setPerson(person);
//
//                session.persist(workplace);
//            transaction.commit();
//        session.close();

//        Session session = hibernateUtil.getSessionFactory().openSession();
//        final List<Person> fromPerson = session.createQuery("from Person ", Person.class).list();
//        for (Person person : fromPerson) {
//            System.out.println("person = " + person);
//        }
//        session.close();



//        final Session session = hibernateUtil.getSessionFactory().openSession();
//        final Person person = session.get(Person.class, 51L);
//        System.out.println("person = " + person);

        // Adding another new work place through Workplace entity
//        final Session session = hibernateUtil.getSessionFactory().openSession();
//            final Transaction transaction = session.beginTransaction();
//                final Person person = session.get(Person.class, 52L);
//
//                Workplace workplace = new Workplace();
//                workplace.setPlace("School");
//                workplace.setPerson(person);
//
//                session.persist(workplace);
//            transaction.commit();

//        final Session session = hibernateUtil.getSessionFactory().openSession();
//            final Transaction transaction = session.beginTransaction();
//                final Person person = session.get(Person.class, 51L);
//
//                Workplace workplace = new Workplace();
//                workplace.setPlace("247 lS");
//                workplace.setPerson(person);
//
//                session.persist(workplace);
//
//            transaction.commit();
//        session.close();


    }

}
