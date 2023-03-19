package cli;

import passenger.HibernatePassengerDAOService;
import passenger.IPassengerDAOService;
import passenger.Passenger;
import planet.Planet;
import ticket.HibernateTicketDAOService;
import ticket.ITicketDAOService;
import ticket.Ticket;

import java.sql.SQLException;

public class AddTicketState extends CliState {
    public AddTicketState(CliFsm fsm) {
        super(fsm);
    }

    @Override
    public void init() {
        try {
            IPassengerDAOService passengerDAOService = new HibernatePassengerDAOService();

            System.out.println("Enter passenger passport:");
            String passport = fsm.getScanner().nextLine();
            Passenger passenger = passengerDAOService.getByPassport(passport);

            if (passenger != null) {
                System.out.println("Passenger " + passenger.getName() + " found. Enter FROM planet: ");
            } else {
                System.out.println("Enter passenger name:");
                String passengerName = fsm.getScanner().nextLine();
                passenger = new Passenger(passport, passengerName);
                passengerDAOService.create(passenger);
                passenger = passengerDAOService.getByPassport(passport);
                System.out.println("Passenger saved. Enter FROM planet:");
            }

            Planet planetFrom = new PlanetChooser(fsm.getScanner()).ask();
            System.out.println(planetFrom + " found. Enter TO planet:");
            Planet planetTo = new PlanetChooser(fsm.getScanner()).ask();

            ITicketDAOService ticketDAOService = new HibernateTicketDAOService();
            Ticket newTicket =
                    new Ticket(passenger.getId(), planetFrom, planetTo);
            long ticketId = ticketDAOService.create(newTicket);

            System.out.println(planetTo + " found. Ticket ordered, ID: " + ticketId);
            fsm.setState(new IdleState(fsm));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
