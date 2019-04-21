package service;

import tools.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Modify {
    public static void modifyStudentById(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要修改的学生学号：");
        int studentId = scanner.nextInt();
        System.out.println("请输入需要修改的内容：\n1. 姓名\n2. 年龄\n3. 性别");
        int option = scanner.nextInt();
        String column = "";
        String value = "";

        switch (option) {
            case 1:
                column = "name";
                System.out.println("请输入修改后的姓名：");
                value = scanner.next();
                break;
            case 2:
                column = "age";
                System.out.println("请输入修改后的年龄：");
                value = scanner.next();
                break;
            case 3:
                column = "sex";
                System.out.println("请输入修改后的性别：");
                value = scanner.next();
                break;
        }

        try (Statement st = Database.getStatement(connection)) {
            st.execute("UPDATE student_info SET `" + column + "`=\'" + value + "\' WHERE student_id = " + studentId);
            System.out.println("修改成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Menu.showAdminMenu(connection);
    }

    public static void modifyTeacherById(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要修改的教师工号：");
        int teacherId = scanner.nextInt();
        System.out.println("请输入需要修改的内容：\n1. 姓名\n2. 年龄\n3. 性别");
        int option = scanner.nextInt();
        String column = "";
        String value = "";

        switch (option) {
            case 1:
                column = "name";
                System.out.println("请输入修改后的姓名：");
                value = scanner.next();
                break;
            case 2:
                column = "age";
                System.out.println("请输入修改后的年龄：");
                value = scanner.next();
                break;
            case 3:
                column = "sex";
                System.out.println("请输入修改后的性别：");
                value = scanner.next();
                break;
        }

        try (Statement st = Database.getStatement(connection)) {
            st.execute("UPDATE teacher_info SET `" + column + "`=\'" + value + "\' WHERE teacher_id = " + teacherId);
            System.out.println("修改成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Menu.showAdminMenu(connection);
    }

    public static void modifySubjectById(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要修改的课程编号：");
        int subjectId = scanner.nextInt();
        System.out.println("请输入需要修改的内容：\n1. 课程名称\n2. 代教老师");
        int option = scanner.nextInt();
        String column = "";
        String value = "";

        switch (option) {
            case 1:
                column = "name";
                System.out.println("请输入修改后的课程名称：");
                value = scanner.next();
                break;
            case 2:
                column = "teacher_id";
                System.out.println("请输入修改后的教师工号：");
                value = scanner.next();
                break;
        }

        try (Statement st = Database.getStatement(connection)) {
            st.execute("UPDATE subjects SET `" + column + "`=\'" + value + "\' WHERE subject_id = " + subjectId);
            System.out.println("修改成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Menu.showAdminMenu(connection);
    }

    public static void modifyScoreByStudentId(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要修改的学生学号：");
        int studentId = scanner.nextInt();
        System.out.println("请输入需要修改的考试代码：");
        int examinationId = scanner.nextInt();
        System.out.println("请输入修改后的分数：");
        int score = scanner.nextInt();

        try (Statement st = Database.getStatement(connection)) {
            st.execute("UPDATE scores SET score  = " + score + " WHERE (student_id = " + studentId + " AND examination_id = " + examinationId + ")");
            System.out.println("修改成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Menu.showAdminMenu(connection);
    }
}

