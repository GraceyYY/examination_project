package service;

import dao.UserDao;
import module.User;
import tools.Database;

import java.sql.Connection;
import java.sql.SQLException;

public class Login {
    public static int authenticate(Connection connection, String input) {
        if (Input.isLoginInfoValid(input)) {
            String userName = input.split(":")[0];
            String password = input.split(":")[1];

            User user = new UserDao(connection, userName).user;
            if (password.equals(user.getPassword())) {
                return user.getRole();
            }
        }

        return 0;
    }

    public static void logOut(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
