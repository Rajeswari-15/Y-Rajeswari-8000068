package com.example.advanced;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionThrowerTest {

    ExceptionThrower obj = new ExceptionThrower();

    @Test
    void testException() {

        RuntimeException exception =
                assertThrows(RuntimeException.class,
                        () -> obj.throwException());

        assertEquals("Invalid operation occurred",
                exception.getMessage());
    }
}