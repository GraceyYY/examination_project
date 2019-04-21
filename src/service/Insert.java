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
            String[] studentInfo = input.split("，");
            int id = Integer.parseInt(studentInfo[0].split("：")[1]);
            String name = studentInfo[1].split("：")[1];
            int age = Integer.parseInt(studentInfo[2].split("：")[1]);
            String sex = studentInfo[3].split("：")[1];
            int userId = Integer.parseInt(studentInfo[4].split("：")[1]);

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

    public static void insertSubject(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入课程信息(例如：课程编号：5011，课程名称：生物，教师工号：9011)：");
        String input = scanner.next();
        if (Input.isSubjectInfoValid(input)) {
            String[] subjectInfo = input.split("，");
            int id = Integer.parseInt(subjectInfo[0].split("：")[1]);
            String name = subjectInfo[1].split("：")[1];
            int teacherId = Integer.parseInt(subjectInfo[2].split("：")[1]);

            try (Statement st = Database.getStatement(connection)) {
                st.execute("INSERT INTO subjects VALUES (null, " + id + ", \'" + name + "\', " + teacherId + ")");
                System.out.println("添加课程" + name + "(" + id + ")" + "成功");
            } catch (SQLException e) {
                System.out.println("添加失败");
                e.printStackTrace();
            }
        } else {
            System.out.println("请按照正确的格式输入课程信息(例如：课程编号：5011，课程名称：生物，教师工号：9011)：");
            insertSubject(connection);
        }

        Menu.showAdminMenu(connection);
    }

    public static void insertTeacher(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入教师信息(例如：工号：9001，姓名：张明，年龄：48，性别：男，用户编号：33)：");
        String input = scanner.next();
        if (Input.isTeacherInfoValid(input)) {
            String[] teacherInfo = input.split("，");
            int id = Integer.parseInt(teacherInfo[0].split("：")[1]);
            String name = teacherInfo[1].split("：")[1];
            int age = Integer.parseInt(teacherInfo[2].split("：")[1]);
            String sex = teacherInfo[3].split("：")[1];
            int userId = Integer.parseInt(teacherInfo[4].split("：")[1]);

            try (Statement st = Database.getStatement(connection)) {
                st.execute("INSERT INTO student_info VALUES (" + userId + ", " + id + ", \'" + name + "\', " + age + ", \'" + sex + "\')");
                System.out.println("添加教师" + name + "(" + id + ")" + "成功");
            } catch (SQLException e) {
                System.out.println("添加失败");
                e.printStackTrace();
            }
        } else {
            System.out.println("请按照正确的格式输入教师信息(例如：工号：9001，姓名：张明，年龄：48，性别：男，用户编号：33)：");
            insertTeacher(connection);
        }

        Menu.showAdminMenu(connection);

    }

    public static void insertScore(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入教师信息(例如：学号：9001，考试编号：10042，成绩：89)：");
        String input = scanner.next();
        if (Input.isScoreInfoValid(input)) {
            String[] scoreInfo = input.split("，");
            int studentId = Integer.parseInt(scoreInfo[0].split("：")[1]);
            int examinationId = Integer.parseInt(scoreInfo[1].split("：")[1]);
            int score = Integer.parseInt(scoreInfo[2].split("：")[1]);

            try (Statement st = Database.getStatement(connection)) {
                st.execute("INSERT INTO student_info VALUES (null, " + examinationId + ", " + studentId + ", " + score + ")");
                System.out.println("添加成绩" + studentId + "(" + score + "分)" + "成功");
            } catch (SQLException e) {
                System.out.println("添加失败");
                e.printStackTrace();
            }
        } else {
            System.out.println("请按照正确的格式输入成绩信息(例如：学号：9001，考试编号：10042，成绩：89)：");
            insertScore(connection);
        }

        Menu.showAdminMenu(connection);

    }


}
