package jm.task.core.jdbc;

import jm.task.core.jdbc.util.Util;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        Class<Driver> driverClass = Driver.class;
        String createTable = """
                
                
                
                """;
        try (Connection connection = Util.open();
             var statement = connection.createStatement()) {
            System.out.println(connection.getTransactionIsolation());
            boolean executeResult = statement.execute(createTable);
            System.out.println(executeResult);
        }
    }
}
