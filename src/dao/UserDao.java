package dao;

import module.User;
import tools.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
    public User user;

    public UserDao(Connection connection, String userName) {
        try (Statement st = Database.getStatement(connection);
             ResultSet rs = Database.executeSQL(st, "SELECT * FROM users WHERE user_name = \'" + userName + "\'")) {
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String password = rs.getString("password");
                int role = rs.getInt("role");
                this.user = new User(userId, userName, password, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserDao(Connection connection, int userId) {
        try (Statement st = Database.getStatement(connection);
             ResultSet rs = Database.executeSQL(st, "SELECT * FROM users WHERE user_id = " + userId)) {

            while (rs.next()) {
                String userName = rs.getString("user_name");
                int role = rs.getInt("role");
                String password = rs.getString("password");
                this.user = new User(userId, userName, password, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
