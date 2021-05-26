package me.putz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordCheckerTest {
    PasswordChecker pwc = new PasswordChecker();

    @Test
    @DisplayName("Check valid password for all rules")
    public void checkPassword_valid(){
        assertTrue(pwc.checkPassword("thisIsValid12!"));
    }

    @Test
    @DisplayName("Check invalid password for all rules")
    public void checkPassword_invalid(){
        assertFalse(pwc.checkPassword("thisIsN0Val1dPassword!?%end"));
    }

    @Test
    @DisplayName("Password too short")
    public void checkPwLen_tooShort(){
        assertFalse(pwc.checkPwLen("1234567"));
    }

    @Test
    @DisplayName("Password too long")
    public void checkPwLen_tooLong(){
        assertFalse(pwc.checkPwLen("abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    @DisplayName("Password length valid")
    public void checkPwLen_validLength(){
        assertTrue(pwc.checkPwLen("validLength"));
    }

    @Test
    @DisplayName("No upper case letters")
    public void checkPwUpperLowerCase_noUpper(){
        assertFalse(pwc.checkPwUpperLowerCase("nouppercaseletters"));
    }

    @Test
    @DisplayName("No lower case letters")
    public void checkPwUpperLowerCase_noLower(){
        assertFalse(pwc.checkPwUpperLowerCase("NOLOWERCASELETTERS"));
    }

    @Test
    @DisplayName("Contains upper and lower case letters")
    public void checkPwUpperLowerCase_upperAndLower(){
        assertTrue(pwc.checkPwUpperLowerCase("upperAndLowerCase"));
    }

    @Test
    @DisplayName("Password contains no numbers")
    public void checkPwContainsNumbers_noNumber() {
        assertFalse(pwc.checkPwContainsNumbers("noNumbers"));
    }

    @Test
    @DisplayName("Password contains only one number")
    public void checkPwContainsNumbers_oneNumber() {
        assertFalse(pwc.checkPwContainsNumbers("only1Number"));
    }

    @Test
    @DisplayName("Password contains >=2 numbers")
    public void checkPwContainsNumbers_enoughNumbers() {
        assertTrue(pwc.checkPwContainsNumbers("enough1Numbers2"));
    }

    @Test
    @DisplayName("No valid special character")
    public void checkPwContainsValidSpecialCharacters_noSpecialCharacters(){
        assertFalse(pwc.checkPwContainsValidSpecialCharacters("noSpecialCharacters"));
    }

    @Test
    @DisplayName("Invalid special character")
    public void checkPwContainsValidSpecialCharacters_invalidSpecialCharacters(){
        assertFalse(pwc.checkPwContainsValidSpecialCharacters("invalid_special-characters"));
    }

    @Test
    @DisplayName("Contains valid special character")
    public void checkPwContainsValidSpecialCharacters_validSpecialCharacters(){
        assertTrue(pwc.checkPwContainsValidSpecialCharacters("only(valid)specialChars!"));
    }

    @Test
    @DisplayName("progressive numbers without numbers")
    public void checkPwContainsValidProgressiveNumbers_noNumbers(){
        assertTrue(pwc.checkPwContainsValidProgressiveNumbers("noProgressiveNumbers"));
    }

    @Test
    @DisplayName("No progressive numbers")
    public void checkPwContainsValidProgressiveNumbers_noProgressiveNumbers(){
        assertTrue(pwc.checkPwContainsValidProgressiveNumbers("no1Progressive3Numbers2"));
    }

    @Test
    @DisplayName("Valid progressive numbers")
    public void checkPwContainsValidProgressiveNumbers_validProgressiveNumbers(){
        assertTrue(pwc.checkPwContainsValidProgressiveNumbers("valid1Progressive2Numbers"));
    }

    @Test
    @DisplayName("too many progressive numbers")
    public void checkPwContainsValidProgressiveNumbers_tooManyProgressiveNumbers(){
        assertFalse(pwc.checkPwContainsValidProgressiveNumbers("too1Many2Progressive3Numbers"));
    }

    @Test
    @DisplayName("consecutive numbers without numbers")
    public void checkPwContainsSameNumbersConsecutively_noNumbers(){
        assertTrue(pwc.checkPwContainsSameNumbersConsecutively("noConsecutiveNumbers"));
    }

    @Test
    @DisplayName("no consecutive numbers")
    public void checkPwContainsSameNumbersConsecutively_noConsecutiveNumbers(){
        assertTrue(pwc.checkPwContainsSameNumbersConsecutively("noConsecutiveNumbers121212"));
    }

    @Test
    @DisplayName("valid amount of consecutive numbers")
    public void checkPwContainsSameNumbersConsecutively_validConsecutiveNumbers(){
        assertTrue(pwc.checkPwContainsSameNumbersConsecutively("valid1Consecutive1Numbers1"));
    }

    @Test
    @DisplayName("too many consecutive numbers")
    public void checkPwContainsSameNumbersConsecutively_tooManyConsecutiveNumbers(){
        assertFalse(pwc.checkPwContainsSameNumbersConsecutively("too1Many1Consecutive1Numbers1"));
    }
}
