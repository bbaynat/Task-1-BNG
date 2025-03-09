package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {

    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Ann", "Brown", (byte) 18);
        userService.saveUser("Ben", "Green", (byte) 28);
        userService.saveUser("Jack", "Black", (byte) 34);
        userService.saveUser("George", "Cooper", (byte) 56);

        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }
       userService.cleanUsersTable();
       userService.dropUsersTable();

    }
}
