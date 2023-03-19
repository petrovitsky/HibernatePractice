package storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionProvider {
    private List<Connection> connections;

    public ConnectionProvider() {
        this.connections = new ArrayList<>();
    }

    public Connection createConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(StorageConstants.CONNECTION_URL);
        connections.add(connection);
        return connection;
    }

    public void close() throws SQLException {
        for (Connection connection : connections) {
            if (connection.isClosed()){
                continue;
            }
            connection.close();
        }
    }


}
