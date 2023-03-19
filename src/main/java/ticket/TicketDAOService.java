package ticket;

import planet.Planet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDAOService implements ITicketDAOService {
    private PreparedStatement createSt;
    private PreparedStatement getMaxIdSt;
    private PreparedStatement getTicketCountToPlanetSt;

    public TicketDAOService(Connection connection) throws SQLException {
        createSt = connection.prepareStatement("INSERT INTO ticket (passenger_id, from_planet, to_planet) VALUES ( ?, ?, ?)");
        getMaxIdSt = connection.prepareStatement("SELECT max(id) AS maxId FROM ticket");
        getTicketCountToPlanetSt = connection.prepareStatement("SELECT count(*) FROM ticket WHERE to_planet = ? ");
    }

    public long create(Ticket ticket) throws SQLException {
        createSt.setLong(1, ticket.getPassengerId());
        createSt.setString(2, ticket.getFrom().name());
        createSt.setString(3, ticket.getTo().name());
        createSt.executeUpdate();

        try (ResultSet rs = getMaxIdSt.executeQuery()) {
            rs.next();
            long maxId = rs.getLong("maxId");
            return maxId;
        }
    }

    public long getTicketCountToPlanet(Planet planet) throws SQLException {
        getTicketCountToPlanetSt.setString(1, planet.name());
        try (ResultSet rs = getTicketCountToPlanetSt.executeQuery()) {
            rs.next();
            return rs.getLong(1);
        }
    }

}
