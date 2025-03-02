package jm.task.core.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UtilProperties {
    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }

    private static void loadProperties() {
        try (InputStream InputStream = Util.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(InputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private UtilProperties() {
    }
}
