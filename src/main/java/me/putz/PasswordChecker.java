package me.putz;

public class PasswordChecker {

    public boolean checkPassword(String pw) {
        return checkPwLen(pw) && checkPwUpperLowerCase(pw);
    }

    public boolean checkPwLen(String pw) {
        return pw.length() >= 8 && pw.length() <= 25;
    }

    public boolean checkPwUpperLowerCase(String pw) {
        return pw.matches(".*[a-z]+.*") && pw.matches(".*[A-Z]+.*");
    }

    // "Das Kennwort muss Zahlen enthalten." => at least 2 numbers ?
    public boolean checkPwContainsNumbers(String pw) {
        return pw.matches(".*\\d.*\\d.*");
    }
}
