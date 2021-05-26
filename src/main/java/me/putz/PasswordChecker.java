package me.putz;

public class PasswordChecker {

    public boolean checkPassword(String pw) {
        return checkPwLen(pw);
    }

    public boolean checkPwLen(String pw) {
        return pw.length() >= 8 && pw.length() <= 25;
    }

}
