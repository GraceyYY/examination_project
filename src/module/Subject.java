package module;

public class Subject {
    public int subjectId;
    public String name;
    public Teacher teacher;

    public Subject(int subjectId, String name, Teacher teacher) {
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

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "课程{" +
                "课程代码:" + subjectId +
                ", 课程名称:" + name +
                ", 代课老师:" + teacher.getName() +
                '}';
    }
}
