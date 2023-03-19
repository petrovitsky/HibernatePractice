package cli;

import planet.Planet;
import ticket.HibernateTicketDAOService;
import ticket.ITicketDAOService;

import java.sql.SQLException;

public class PlanetStatsState extends CliState {
    public PlanetStatsState(CliFsm fsm) {
        super(fsm);
    }

    @Override
    public void init() {
        System.out.println("Enter to planet");
        Planet planet = new PlanetChooser(fsm.getScanner()).ask();
        try {
            ITicketDAOService ticketDAOService = new HibernateTicketDAOService();
            long ticketCountToPlanet = ticketDAOService.getTicketCountToPlanet(planet);
            System.out.println(planet + " found. Ticket count: " + ticketCountToPlanet);
            fsm.setState(new IdleState(fsm));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
