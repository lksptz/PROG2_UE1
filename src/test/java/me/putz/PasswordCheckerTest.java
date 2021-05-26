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
}
