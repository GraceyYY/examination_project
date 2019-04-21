package service;

import dao.*;
import module.*;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Search {
    public static void searchScoreByStudentName(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查询的学生姓名：");
        String studentName = scanner.next();
        Student student = new StudentDao(connection, studentName).student;
        if (student != null) {
            System.out.println(student.toString());
            List<Score> scores = new ScoreDao(connection, student).allScores;
            if (scores.size() > 0) {
                scores.stream().forEach(score -> System.out.println(score.toString()));
            } else {
                System.out.println("系统中没有该学生的成绩信息");
            }
        } else {
            System.out.println("未查询到该学生！");
            searchScoreByStudentName(connection);
        }

        Menu.showAdminMenu(connection);

    }

    public static void searchScoreByTeacherName(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入教师姓名：");
        String teacherName = scanner.next();

        Teacher teacher = new TeacherDao(connection, teacherName).teacher;
        if (teacher != null) {
            Subject subject = new SubjectDao(connection, teacher).subject;
            Examination examination = new ExaminationDao(connection, subject).examination;
            List<Student> students = new StudentDao(connection, examination).allStudents;
            if (students.size() > 0) {
                for (Student stu : students) {
                    List<Score> scores = new ScoreDao(connection, stu, subject).allScores;
                    scores.stream().forEach(score -> System.out.println(score.toString()));
                }
            } else {
                System.out.println("未查询到成绩信息");
            }
        } else {
            System.out.println("未查询到教师信息");
            searchScoreByTeacherName(connection);
        }

        Menu.showAdminMenu(connection);
    }

    public static void searchScoreBySubjectName(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入课程名称：");
        String subjectName = scanner.next();

        Subject subject = new SubjectDao(connection, subjectName).subject;
        if (subject != null) {
            Examination examination = new ExaminationDao(connection, subject).examination;
            List<Student> students = new StudentDao(connection, examination).allStudents;
            if (students.size() > 0) {
                for (Student stu : students) {
                    List<Score> scores = new ScoreDao(connection, stu, subject).allScores;
                    scores.stream().forEach(score -> System.out.println(score.toString()));
                }
            } else {
                System.out.println("未查询到成绩信息");
            }
        } else {
            System.out.println("未查询到课程信息");
            searchScoreBySubjectName(connection);
        }

        Menu.showAdminMenu(connection);

    }
}
