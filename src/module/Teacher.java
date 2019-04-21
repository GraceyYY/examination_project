package module;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
    public int teacherId;
    public int userId;
    public String name;
    public int age;
    public String sex;
    public Set<Subject> subjects;


    public Teacher(int teacherId, int userId, String name, int age, String sex) {
        this.teacherId = teacherId;
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.subjects = new HashSet<>();
    }

    public int getTeacherId() {
        return this.teacherId;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getSex() {
        return this.sex;
    }

    public Set<Subject> getSubjects() {
        return this.subjects;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void assignSubject(Subject subject) {
        this.subjects.add(subject);
    }


    @Override
    public String toString() {
        return "教师{" +
                "工号:" + teacherId +
                ", 姓名:" + name +
                ", 年龄:" + age +
                ", 性别:" + sex +
                '}';
    }
}
