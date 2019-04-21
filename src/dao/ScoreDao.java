package dao;

import module.Examination;
import module.Score;
import module.Student;
import module.Subject;
import tools.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ScoreDao {
    public List<Score> allScores;

    public ScoreDao(Connection connection, Student student) {
        this.allScores = new ArrayList<>();

        try (Statement st = Database.getStatement(connection);
             ResultSet rs = Database.executeSQL(st, "SELECT * FROM scores INNER JOIN examinations USING (examination_id) WHERE student_id = " + student.getStudentId())) {

            while (rs.next()) {
                Examination examination = new ExaminationDao(connection, rs.getInt("examination_id")).examination;
                Subject subject = new SubjectDao(connection, rs.getInt("subject_id")).subject;
                int score = rs.getInt("score");

                allScores.add(new Score(student, examination, subject, score));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
