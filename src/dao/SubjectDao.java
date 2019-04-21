package dao;

import module.Subject;
import module.Teacher;
import tools.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao {
    public Subject subject;
    public List<Subject> allSubjects;

    public SubjectDao(Connection connection, int subjectId) {
        try (Statement st = Database.getStatement(connection);
             ResultSet rs = Database.executeSQL(st, "SELECT * FROM subjects WHERE subject_id = " + subjectId)) {
            while (rs.next()) {
                String name = rs.getString("name");
                Teacher teacher = new TeacherDao(connection, rs.getInt("teacher_id")).teacher;

                this.subject = new Subject(subjectId, name, teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SubjectDao(Connection connection, String subjectName) {
        try (Statement st = Database.getStatement(connection);
             ResultSet rs = Database.executeSQL(st, "SELECT * FROM subjects WHERE name = \'" + subjectName + "\'")) {
            while (rs.next()) {
                int subjectId = rs.getInt("subject_id");
                Teacher teacher = new TeacherDao(connection, rs.getInt("teacher_id")).teacher;

                this.subject = new Subject(subjectId, subjectName, teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SubjectDao(Connection connection, Teacher teacher) {
        this.allSubjects = new ArrayList<>();
        try (Statement st = Database.getStatement(connection);
             ResultSet rs = Database.executeSQL(st, "SELECT * FROM subjects WHERE teacher_id = " + teacher.getTeacherId())) {
            while (rs.next()) {
                int subjectId = rs.getInt("subject_id");
                String name = rs.getString("name");
                this.allSubjects.add(new Subject(subjectId, name, teacher));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SubjectDao(Connection connection) {
        this.allSubjects = new ArrayList<>();
        try (Statement st = Database.getStatement(connection);
             ResultSet rs = Database.executeSQL(st, "SELECT * FROM subjects")) {
            while (rs.next()) {
                int subjectId = rs.getInt("subject_id");
                String name = rs.getString("name");
                Teacher teacher = new TeacherDao(connection, rs.getInt("teacher_id")).teacher;
                this.allSubjects.add(new Subject(subjectId, name, teacher));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
