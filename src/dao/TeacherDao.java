package dao;

import module.Teacher;
import tools.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TeacherDao {
    public Teacher teacher;

    public TeacherDao(int teacherId) {
        try (Statement st = Database.getStatement(Database.getConnect());
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
}
