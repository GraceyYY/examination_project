package service;

import tools.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {
    public static void deleteStudent(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("删除学生之后，该学生信息将不能恢复，是否要继续删除？\n1. 是\n2. 否");
        int option = scanner.nextInt();
        if (option == 1) {
            System.out.println("请输入需要删除的学生学号：");
            int studentId = scanner.nextInt();

            try (Statement st = Database.getStatement(connection)) {
                st.execute("DELETE FROM student_info WHERE student_id = " + studentId);
                System.out.println("删除成功");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        Menu.showAdminMenu(connection);
    }

    public static void deleteSubject(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("删除课程之后，课程信息将不能恢复，是否要继续删除？\n1. 是\n2. 否");
        int option = scanner.nextInt();
        if (option == 1) {
            System.out.println("请输入需要删除的课程编号：");
            int subjectId = scanner.nextInt();

            try (Statement st = Database.getStatement(connection)) {
                st.execute("DELETE FROM subjects WHERE subject_id = " + subjectId);
                System.out.println("删除成功");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        Menu.showAdminMenu(connection);
    }

    public static void deleteTeacher(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("删除教师之后，该教师信息将不能恢复，是否要继续删除？\n1. 是\n2. 否");
        int option = scanner.nextInt();
        if (option == 1) {
            System.out.println("请输入需要删除的教师工号：");
            int teacherId = scanner.nextInt();

            try (Statement st = Database.getStatement(connection)) {
                st.execute("DELETE FROM teacher_info WHERE teacher_id = " + teacherId);
                System.out.println("删除成功");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        Menu.showAdminMenu(connection);
    }
}
