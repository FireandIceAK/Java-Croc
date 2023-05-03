package ru.croc.finalProject.src;

import org.h2.engine.Role;
import org.h2.engine.User;

import java.sql.*;

public class UserDao {
    private final Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public void createTables() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS ROLE ("
                    + "ID INT PRIMARY KEY,"
                    + "NAME VARCHAR(50) UNIQUE NOT NULL"
                    + ")");
            statement.execute("CREATE TABLE IF NOT EXISTS USER ("
                    + "ID INT PRIMARY KEY,"
                    + "LOGIN VARCHAR(50) UNIQUE NOT NULL,"
                    + "PASSWORD VARCHAR(255) NOT NULL,"
                    + "ROLE_ID INT NOT NULL,"
                    + "FOREIGN KEY (ROLE_ID) REFERENCES ROLE(ID)"
                    + ")");
        }
    }

    public boolean checkUserExists(String login) throws SQLException {
        boolean result;
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT COUNT(*) FROM USER WHERE LOGIN = ?")) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            result = resultSet.getInt(1) > 0;
        }
        return result;
    }

    public User getUserByLogin(String login) throws SQLException {
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT USER.ID, PASSWORD, ROLE_ID, NAME FROM USER, ROLE " +
                        "WHERE USER.ROLE_ID = ROLE.ID AND LOGIN = ?")) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User(
                        resultSet.getInt("ID"),
                        login,
                        resultSet.getString("PASSWORD"),
                        new Role(resultSet.getInt("ROLE_ID"), resultSet.getString("NAME"))
                );
            }
        }
        return user;
    }

    public void createUser(User user) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO USER (ID, LOGIN, PASSWORD, ROLE_ID) VALUES (?, ?, ?, ?)")) {
            statement.setInt(1, user.getId());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getRole().getId());
            statement.executeUpdate();
        }
    }

    public void createRole(Role role) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO ROLE (ID, NAME) VALUES (?, ?)")) {
            statement.setInt(1, role.getId());
            statement.setString(2, role.getName());
            statement.executeUpdate();
        }
    }
}