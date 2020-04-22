package five;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DerbyConnectionPool {

    private final int MAX_CONNECTION = 10;

    private final String URL;
    private final String username;
    private final String password;
    private final List<Connection> usedConnection;
    private final List<Connection> availableConnection;

    public DerbyConnectionPool(String URL, String username, String password) {
        this.URL = URL;
        this.username = username;
        this.password = password;
        this.usedConnection = new ArrayList<>();
        this.availableConnection = new ArrayList<>();
        for (int i = 0; i < MAX_CONNECTION; i++) {
            availableConnection.add(createConnection());
        }
    }

    private Connection createConnection() {
        try (Connection connection = DriverManager.getConnection(this.URL, this.username, this.password)) {
            return connection;
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public Connection getConnection() {
        if (availableConnection.isEmpty()) {
            System.out.println("Konekcije su iskoristene");
            return null;
        } else {
            Connection c = availableConnection.remove(availableConnection.size() - 1);
            usedConnection.add(c);
            return c;
        }
    }

    public boolean realseConnection(Connection c) {
        if (null != c) {
            usedConnection.remove(c);
            availableConnection.add(c);
            return true;
        } else {
            return false;
        }
    }

    public int getFreeCountOfConnections() {
        return availableConnection.size();
    }
    
    
    
}
