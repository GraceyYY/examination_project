package dao;

import module.Student;
import tools.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {
    public Student student;

    public StudentDao(Connection connection, int studentId) {

        try (
                Statement st = Database.getStatement(connection);
                ResultSet rs = Database.executeSQL(st, "SELECT * FROM student_info WHERE student_id = " + studentId)) {
            while (rs.next()) {
                int id = rs.getInt("student_id");
                int userId = rs.getInt("user_id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String sex = rs.getString("sex");
                this.student = new Student(id, userId, name, age, sex);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public StudentDao(Connection connection, String studentName) {

        try (
                Statement st = Database.getStatement(connection);
                ResultSet rs = Database.executeSQL(st, "SELECT * FROM student_info WHERE name = \'" + studentName + "\'")) {
            while (rs.next()) {
                int id = rs.getInt("student_id");
                int userId = rs.getInt("user_id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String sex = rs.getString("sex");
                this.student = new Student(id, userId, name, age, sex);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
