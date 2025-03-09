//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//public class UserDaoJDBCImpl implements UserDao {
//
//    public UserDaoJDBCImpl() {
//    }
//    private final Connection connection = Util.getJDBC();
//
//    public void createUsersTable() {
//        String createTable = """
//                CREATE TABLE IF NOT EXISTS USERS (
//                id  BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
//                name VARCHAR(255) NOT NULL,
//                lastname VARCHAR(255) NOT NULL,
//                age INT NOT NULL
//                )
//                """;
//        try ( Connection connection = Util.getJDBC();
//             var statement = connection.createStatement()) {
//             statement.execute(createTable);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void dropUsersTable() {
//        String dropTable = """
//                DROP TABLE IF EXISTS users;
//                """;
//        try (Connection connection = Util.getJDBC();
//             var statement = connection.createStatement()) {
//            statement.execute(dropTable);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        String save = """
//                INSERT INTO users (name, lastname, age)
//                VALUES (?, ?, ?)
//                """;
//        try (Connection connection = Util.getJDBC();
//             PreparedStatement statement = connection.prepareStatement(save);) {
//            statement.setString(1, name);
//            statement.setString(2, lastName);
//            statement.setByte(3, age);
//            statement.executeUpdate();
//            System.out.println("User c именем " + name + " добавлен в базу данных.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public void removeUserById(long id) {
//        String deleteUser = """
//                DELETE FROM users WHERE id = ?
//                """;
//        try (Connection connection = Util.getJDBC();
//             PreparedStatement statement = connection.prepareStatement(deleteUser);) {
//            statement.setLong(1, id);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<User> getAllUsers() {
//        List<User> usersList = new ArrayList<>();
//        String getAll = """
//                SELECT * FROM users
//                """;
//        try (Connection connection = Util.getJDBC();
//             Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(getAll)) {
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getLong("id"));
//                user.setName(resultSet.getString("name"));
//                user.setLastName(resultSet.getString("lastname"));
//                user.setAge(resultSet.getByte("age"));
//                usersList.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return usersList;
//    }
//
//    public void cleanUsersTable() {
//        String cleanTable = """
//                TRUNCATE TABLE users;
//                """;
//        try (Connection connection = Util.getJDBC();
//             var statement = connection.createStatement()) {
//            statement.executeUpdate(cleanTable);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
