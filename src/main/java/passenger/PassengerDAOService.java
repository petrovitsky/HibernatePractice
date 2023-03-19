package passenger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerDAOService implements IPassengerDAOService {
    private PreparedStatement createSt;
    private PreparedStatement getByPassportSt;


    public PassengerDAOService(Connection con) throws SQLException {
        createSt = con.prepareStatement("INSERT INTO passenger (passport, name) VALUES (?, ?)");
        getByPassportSt = con.prepareStatement("SELECT id, name FROM passenger WHERE passport = ?");
    }

    public void create(Passenger passenger) throws SQLException {
        createSt.setString(1, passenger.getPassport());
        createSt.setString(2, passenger.getName());
        createSt.executeUpdate();
    }

    public Passenger getByPassport(String passport) throws SQLException {
        getByPassportSt.setString(1, passport);
        Passenger result = new Passenger(null,null);
        try (ResultSet resultSet = getByPassportSt.executeQuery()) {
             if (!resultSet.next()) {
                return null;
            }
            result.setId(resultSet.getLong(1));
            result.setPassport(passport);
            result.setName(resultSet.getString(2));
        }
        return result;
    }
}
