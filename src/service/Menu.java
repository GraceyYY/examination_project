package service;

import dao.StudentDao;
import dao.SubjectDao;
import dao.TeacherDao;
import module.Student;
import module.Subject;
import module.Teacher;
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
            case "1.1.1": {
                List<Student> students = new StudentDao(connection).allStudents;
                students.stream().forEach(student -> System.out.println(student.toString()));
                showAdminMenu(connection);
                break;
            }
            case "1.1.2": {
                Search.searchScoreByStudentName(connection);
                break;
            }
            case "1.1.3": {
                Search.searchScoreByTeacherName(connection);
                break;
            }
            case "1.1.4": {
                Search.searchScoreBySubjectName(connection);
                break;
            }
            case "1.2.1": {
                List<Subject> subjects = new SubjectDao(connection).allSubjects;
                subjects.stream().forEach(subject -> System.out.println(subject.toString()));
                showAdminMenu(connection);
                break;
            }
            case "1.2.2": {
                Search.searchSubjectByName(connection);
                break;
            }
            case "1.2.3": {
                Search.searchSubjectByTeacherName(connection);
                break;
            }
            case "1.3.1": {
                List<Teacher> teachers = new TeacherDao(connection).allTeachers;
                teachers.stream().forEach(teacher -> System.out.println(teacher.toString()));
                showAdminMenu(connection);
                break;
            }
            case "1.3.2": {
                Search.searchTeacherByName(connection);
                break;
            }
            case "2.1": {
                Insert.insertStudent(connection);
                break;
            }
            case "2.2": {
                Insert.insertSubject(connection);
                break;
            }
            case "2.3": {
                Insert.insertTeacher(connection);
                break;
            }
            case "2.4": {
                Insert.insertScore(connection);
                break;
            }
            case "3.1": {
                Modify.modifyStudentById(connection);
                break;
            }
            case "3.2": {
                Modify.modifySubjectById(connection);
                break;
            }
            case "3.3": {
                Modify.modifyTeacherById(connection);
                break;
            }
            case "3.4": {
                Modify.modifyScoreByStudentId(connection);
                break;
            }
            case "4.1": {
                Delete.deleteStudent(connection);
                break;
            }
            case "4.2": {
                Delete.deleteSubject(connection);
                break;
            }
            case "4.3": {
                Delete.deleteTeacher(connection);
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
