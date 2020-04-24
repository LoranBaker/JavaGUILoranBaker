package five;

import six.ConnectionEnum;
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

      public DerbyConnectionPool() throws SQLException{
          this(ConnectionEnum.URL.getValue(), ConnectionEnum.USERNAME.getValue(),ConnectionEnum.PASSWORD.getValue());
      }
    
    public DerbyConnectionPool(String URL, String username, String password) throws SQLException{
        this.URL = URL;
        this.username= username;
        this.password=password;
        this.usedConnection = new ArrayList<>();
        this.availableConnection = new ArrayList<>();
        for (int i = 0; i < MAX_CONNECTION; i++) {
            availableConnection.add(createConnection());
        }
    }


    private Connection createConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(this.URL, this.username,this.password);
        System.out.println("objekat se kreirao");
            return connection;
            
    }

    public Connection getConnection() {
        if (availableConnection.isEmpty()) {
            throw new RuntimeException("Nema dostupnih konekcija");
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
