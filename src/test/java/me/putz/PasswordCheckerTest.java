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
}
