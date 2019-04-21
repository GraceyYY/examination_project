package service;

import dao.ScoreDao;
import dao.StudentDao;
import module.Score;
import module.Student;
import sun.rmi.runtime.Log;
import tools.Database;
import tools.Print;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void showMainMenu(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("您好，欢迎登陆学生考试系统，请输入您的用户名和密码(用户名:密码)：\n例如：张三:123");
        String input = scanner.next();

        int role = Login.authenticate(connection, input);
        switch (role) {
            case 0:
                System.out.println("用户名和密码输入有误，请重新输入：");
                Menu.showMainMenu(connection);
                break;
            case 1:
                Menu.showAdminMenu(connection);
                break;
            case 2:
                Menu.showStudentMenu();
                break;
            case 3:
                Menu.showTeacherMenu();
                break;
        }

    }

    public static void showAdminMenu(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        Print.printAdminMenu();
        String option = scanner.next();
        switch (option) {
            case "1.1.1":
            {
                List<Student> students = new StudentDao(connection).allStudents;
                students.stream().forEach(student-> System.out.println(student.toString()));
                showAdminMenu(connection);
                break;
            }
            case "1.1.2":
            {
                Search.searchScoreByStudentName(connection);
                break;
            }
            case "1.1.3":
            {
                Search.searchScoreByTeacherName(connection);
                break;
            }
            case "1.1.4":
            {
                Search.searchScoreBySubjectName(connection);
                break;
            }
        }
    }

    public static void showStudentMenu() {
        System.out.println("student");
    }

    public static void showTeacherMenu() {
        System.out.println("teacher");
    }
}
