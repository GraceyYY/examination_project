package dao;

import module.Teacher;
import tools.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {
    public Teacher teacher;
    public List<Teacher> allTeachers;

    public TeacherDao(Connection connection, int teacherId) {
        try (Statement st = Database.getStatement(connection);
             ResultSet rs = Database.executeSQL(st, "SELECT * FROM teacher_info WHERE teacher_id = " + teacherId)) {
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String sex = rs.getString("sex");
                this.teacher = new Teacher(teacherId, userId, name, age, sex);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TeacherDao(Connection connection, String teacherName) {
        try (Statement st = Database.getStatement(connection);
             ResultSet rs = Database.executeSQL(st, "SELECT * FROM teacher_info WHERE name = \'" + teacherName + "\'")) {
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                int teacherId = rs.getInt("teacher_id");
                int age = rs.getInt("age");
                String sex = rs.getString("sex");
                this.teacher = new Teacher(teacherId, userId, teacherName, age, sex);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TeacherDao(Connection connection) {
        this.allTeachers = new ArrayList<>();
        try (Statement st = Database.getStatement(connection);
             ResultSet rs = Database.executeSQL(st, "SELECT * FROM teacher_info")) {
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String sex = rs.getString("sex");
                int teacherId = rs.getInt("teacher_id");
                this.allTeachers.add(new Teacher(teacherId, userId, name, age, sex));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
