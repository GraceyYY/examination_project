package module;

public class Score {
    public Student student;
    public Examination examination;
    public Subject subject;
    public int score;

    public Score(Student student, Examination examination, Subject subject, int score) {
        this.student = student;
        this.examination = examination;
        this.subject = subject;
        this.score = score;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Examination getExamination() {
        return this.examination;
    }

    public void setExamination(Examination examination) {
        this.examination = examination;
    }

    public Subject getSubject() {
        return this.subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "成绩{" +
                "学生:" + student.getName() +
                ", 考试:" + examination.getName() +
                ", 学科:" + subject.getName() +
                ", 成绩:" + score +
                '}';
    }
}
