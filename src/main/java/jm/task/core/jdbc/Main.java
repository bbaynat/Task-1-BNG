package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        Class<Driver> driverClass = Driver.class;

        try (Connection connection = Util.open();
             var statement = connection.createStatement()) {
            System.out.println("Уровень изолированности "+connection.getTransactionIsolation());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Ann", "Brown", (byte) 18);
        userService.saveUser("Ben", "Green", (byte) 28);
        userService.saveUser("Jack", "Black", (byte) 34);
        userService.saveUser("George", "Cooper", (byte) 56);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
