package dao;

import module.Subject;
import module.Teacher;
import tools.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SubjectDao {
    public Subject subject;

    public SubjectDao(Connection connection, int subjectId) {
        try (Statement st = Database.getStatement(connection);
             ResultSet rs = Database.executeSQL(st, "SELECT * FROM subjects WHERE subject_id = " + subjectId)) {
            while (rs.next()) {
                String name = rs.getString("name");
                Teacher teacher = new TeacherDao(connection,rs.getInt("teacher_id")).teacher;

                this.subject = new Subject(subjectId, name, teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SubjectDao(Connection connection, Teacher teacher) {
        try (Statement st = Database.getStatement(connection);
             ResultSet rs = Database.executeSQL(st, "SELECT * FROM subjects WHERE teacher_id = " + teacher.getTeacherId())) {
            while (rs.next()) {
                int subjectId = rs.getInt("subject_id");
                String name = rs.getString("name");
                this.subject = new Subject(subjectId, name, teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
