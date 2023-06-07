package server.sql;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The type Properties provider.
 */
public class PropertiesProvider {
    private static final Properties appProperties = new Properties();

    static {

        try {
            InputStream inputStream = PropertiesProvider.class.getClassLoader().getResourceAsStream("application.properties");
            appProperties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    /**
     * Gets app properties.
     *
     * @return the app properties
     */
    public static Properties getAppProperties() {
        return new Properties(appProperties);
    }
}