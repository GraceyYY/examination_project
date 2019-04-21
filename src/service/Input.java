package service;

public class Input {
    public static boolean isLoginInfoValid(String input) {
        return input.matches("^\\w+:\\w+$");
    }
}
