package org.example;

import cli.CliFsm;
import storage.ConnectionProvider;
import storage.DataBaseInitService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
       new DataBaseInitService().initDB();
//        Connection connection = new ConnectionProvider().createConnection();
//        PassengerDAOService ps = new PassengerDAOService(connection);
//        ps.create(new Passenger("AB111234", "Eugene" ));
//
//        TicketDAOService ts = new TicketDAOService(connection);
//        long result = ts.create(new Ticket(1, Planet.Earth, Planet.Jupiter));
//        System.out.println("result = " + result);

        final ConnectionProvider connectionProvider = new ConnectionProvider();
        new CliFsm(connectionProvider);
        connectionProvider.close();
    }
}