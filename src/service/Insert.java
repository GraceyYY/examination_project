package service;

import tools.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insert {
    public static void insertStudent(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生信息(例如：学号：1001，姓名：小明，年龄：18，性别：男，用户编号：11)：");
        String input = scanner.next();
        if (Input.isStudentInfoValid(input)) {
            String[] student = input.split("，");
            int id = Integer.parseInt(student[0].split("：")[1]);
            String name = student[1].split("：")[1];
            int age = Integer.parseInt(student[2].split("：")[1]);
            String sex = student[3].split("：")[1];
            int userId = Integer.parseInt(student[4].split("：")[1]);

            try (Statement st = Database.getStatement(connection)) {
                st.execute("INSERT INTO student_info VALUES (" + userId + ", " + id + ", \'" + name + "\', " + age + ", \'" + sex + "\')");
                System.out.println("添加学生" + name + "(" + id + ")" + "成功");
            } catch (SQLException e) {
                System.out.println("添加失败");
                e.printStackTrace();
            }
        } else {
            System.out.println("请按照正确的格式输入学生信息(例如：学号：1001，姓名：小明，年龄：18，性别：男，用户编号：11)：");
            insertStudent(connection);
        }

        Menu.showAdminMenu(connection);

    }
}
