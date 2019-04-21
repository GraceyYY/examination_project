package service;

public class Input {
    public static boolean isLoginInfoValid(String input) {
        return input.matches("^\\w+:\\w+$");
    }

    public static boolean isStudentInfoValid(String input) {
        return input.matches("^学号：[0-9]{4}，姓名：[\\u4e00-\\u9fa5]{2,4}，年龄：[1-9]+[0-9]*，性别：[男女]，用户编号：[0-9]+$");
    }

    public static boolean isSubjectInfoValid(String input) {
        return input.matches("^课程编号：[0-9]{4}，课程名称：[\\u4e00-\\u9fa5]{2,}，教师工号：[0-9]{4}$");
    }

    public static boolean isTeacherInfoValid(String input) {
        return input.matches("^工号：[0-9]{4}，姓名：[\\u4e00-\\u9fa5]{2,4}，年龄：[1-9]+[0-9]*，性别：[男女]，用户编号：[0-9]+$");
    }

    public static boolean isScoreInfoValid(String input) {
        return input.matches("^学号：[0-9]{4}，考试编号：[0-9]+，成绩：[0-9]{1,2}$");
    }
}
