package server.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 * The type Sql connection.
 */
public class SQLConnection {
    private final Connection connection;

    /**
     * Instantiates a new Sql connection.
     */
    public SQLConnection() {
        try {
            String url = PropertiesProvider.getAppProperties().getProperty("datasource.url");
            String username = PropertiesProvider.getAppProperties().getProperty("datasource.username");
            String password = PropertiesProvider.getAppProperties().getProperty("datasource.password");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    /**
     * Gets connection.
     *
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }
}
