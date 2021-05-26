package me.putz;

public class PasswordChecker {

    public boolean checkPassword(String pw) {
        return checkPwLen(pw) &&
                checkPwUpperLowerCase(pw) &&
                checkPwContainsNumbers(pw) &&
                checkPwContainsValidSpecialCharacters(pw) &&
                checkPwContainsValidProgressiveNumbers(pw) &&
                checkPwContainsSameNumbersConsecutively(pw);
    }

    public boolean checkPwLen(String pw) {
        return pw.length() >= 8 && pw.length() <= 25;
    }

    public boolean checkPwUpperLowerCase(String pw) {
        return pw.matches("^.*[a-z]+.*$") && pw.matches("^.*[A-Z]+.*$");
    }

    // "Das Kennwort muss Zahlen enthalten." => at least 2 numbers ?
    public boolean checkPwContainsNumbers(String pw) {
        return pw.matches("^.*\\d.*\\d.*$");
    }

    public boolean checkPwContainsValidSpecialCharacters(String pw) {
        return pw.matches("^([a-zA-Z\\d]*[()#$?!%/@]+[a-zA-Z\\d]*)+$");
    }

    public boolean checkPwContainsValidProgressiveNumbers(String pw) {
        String onlyNumbers = pw.replaceAll("\\D", "");
        int count = 1;
        int prev = 10; //any number where no digit == prev + 1
        for (char c : onlyNumbers.toCharArray()){
            int curr = Integer.parseInt(Character.toString(c));
            if (curr == prev + 1){
                count++;
                if (count == 3) {
                    return false;
                }
            } else {
                count = 1;
            }
            prev = curr;
        }
        return true;
    }

    public boolean checkPwContainsSameNumbersConsecutively(String pw) {
        String onlyNumbers = pw.replaceAll("\\D", "");
        int count = 1;
        char prev = ' '; //any non digit character
        for (char c : onlyNumbers.toCharArray()){
            if (c == prev){
                count++;
                if (count == 4) {
                    return false;
                }
            } else {
                count = 1;
            }
            prev = c;
        }
        return true;
    }
}
