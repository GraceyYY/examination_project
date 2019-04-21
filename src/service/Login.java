package service;

import dao.UserDao;
import module.User;

import java.sql.Connection;

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
}
