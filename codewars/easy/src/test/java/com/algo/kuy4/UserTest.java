package com.algo.kuy4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void testSomething() {
        User user = new User();
        user.incProgress(-7);
        assertEquals(10, user.progress);
        user.incProgress(-5);
        assertEquals(0, user.progress);
        assertEquals(-7, user.rank);
    }
}