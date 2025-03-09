package jm.task.core.jdbc.util;

import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@NoArgsConstructor
public class Util {
    // реализуйте настройку соеденения с БД

    private static final String URL_KEY = "db.url";
    private static final String USER_NAME_KEY = "db.user_name";
    private static final String PASSWORD_KEY = "db.password";

    public static Connection open() {
        try {
            return DriverManager.getConnection(
                    UtilProperties.getProperty(URL_KEY),
                    UtilProperties.getProperty(USER_NAME_KEY),
                    UtilProperties.getProperty(PASSWORD_KEY)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
