package module;

public class Examination {
    public int examinationId;
    public Subject subject;
    public int duration;
    public int totalScore;
    public String name;

    public Examination(int examinationId, Subject subject, int duration, int totalScore, String name) {
        this.examinationId = examinationId;
        this.subject = subject;
        this.duration = duration;
        this.totalScore = totalScore;
        this.name = name;
    }

    public int getExaminationId() {
        return this.examinationId;
    }

    public void setExaminationId(int examinationId) {
        this.examinationId = examinationId;
    }

    public Subject getSubject() {
        return this.subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTotalScore() {
        return this.totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "考试{" +
                "考试代码:" + examinationId +
                ",考试名称:" + name +
                ", 所属课程:" + subject.getName() +
                ", 时长:" + duration + "分钟" +
                ", 总分:" + totalScore + "分}";
    }
}
