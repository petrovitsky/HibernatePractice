package ticket;

import planet.Planet;
import java.sql.SQLException;

public interface ITicketDAOService {

    long create(Ticket ticket) throws SQLException;

    long getTicketCountToPlanet(Planet planet) throws SQLException;

}
