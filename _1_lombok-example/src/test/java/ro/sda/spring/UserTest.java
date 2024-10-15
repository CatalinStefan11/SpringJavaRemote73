package ro.sda.spring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    // TDD (Test Driven Development) -> principle which means that the tests are written first and then the source code
    @Test
    void testSetFirstName() {
        User user = new User();
        user.setFirstName("Messi");

        assertEquals("Messi", user.getFirstName());
    }
}
