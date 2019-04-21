package module;

public class Subject {
    public int subjectId;
    public String name;
    public int teacher;

    public Subject(int subjectId, String name, int teacher) {
        this.subjectId = subjectId;
        this.name = name;
        this.teacher = teacher;
    }

    public int getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacher() {
        return this.teacher;
    }

    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }
}
