package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService{

    public void createUsersTable() throws SQLException {
        UserDaoJDBCImpl userDaoJDBCImpl = new UserDaoJDBCImpl();
        userDaoJDBCImpl.createUsersTable();
    }

    public void dropUsersTable() {
        UserDaoJDBCImpl userDaoJDBCImpl = new UserDaoJDBCImpl();
        userDaoJDBCImpl.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        UserDaoJDBCImpl userDaoJDBCImpl = new UserDaoJDBCImpl();
        userDaoJDBCImpl.saveUser(name, lastName, age);

    }

    public void removeUserById(long id) {
        UserDaoJDBCImpl userDaoJDBCImpl = new UserDaoJDBCImpl();
        userDaoJDBCImpl.removeUserById(id);

    }

    public List<User> getAllUsers() {
        UserDaoJDBCImpl userDaoJDBCImpl = new UserDaoJDBCImpl();
        return userDaoJDBCImpl.getAllUsers();
    }

    public void cleanUsersTable() {
        UserDaoJDBCImpl userDaoJDBCImpl = new UserDaoJDBCImpl();
        userDaoJDBCImpl.cleanUsersTable();

    }
}
