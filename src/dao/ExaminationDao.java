package dao;

import module.Examination;
import module.Subject;
import tools.Database;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExaminationDao {
    public Examination examination;

    public ExaminationDao(Connection connection, int examinationId) {
        try (Statement st = Database.getStatement(connection);
             ResultSet rs = Database.executeSQL(st, "SELECT * FROM examinations WHERE examination_id = " + examinationId)) {
            while (rs.next()) {
                String name = rs.getString("name");
                Subject subject = new SubjectDao(connection, rs.getInt("subject_id")).subject;
                int score = rs.getInt("total_score");
                int duration = rs.getInt("duration");

                this.examination = new Examination(examinationId, subject, duration, score, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ExaminationDao(Connection connection, Subject subject) {
        try (Statement st = Database.getStatement(connection);
             ResultSet rs = Database.executeSQL(st, "SELECT * FROM examinations WHERE subject_id = " + subject.getSubjectId())) {
            while (rs.next()) {
                int examinationId = rs.getInt("examination_id");
                String name = rs.getString("name");
                int score = rs.getInt("total_score");
                int duration = rs.getInt("duration");

                this.examination = new Examination(examinationId, subject, score, duration, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
