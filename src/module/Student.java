package module;

public class Student {
    public int studentId;
    public int userId;
    public String name;
    public int age;
    public String sex;

    public Student(int studentId, int userId, String name, int age, String sex) {
        this.studentId = studentId;
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public int getStudentId() {
        return this.studentId;
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

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    @Override
    public String toString() {
        return "学生{" +
                "学号:" + studentId +
                ", 姓名:" + name +
                ", 年龄:" + age +
                ", 性别:" + sex +
                '}';
    }
}
