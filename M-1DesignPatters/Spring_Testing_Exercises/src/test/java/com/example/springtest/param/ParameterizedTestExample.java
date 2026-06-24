package com.example.springtest.param;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ParameterizedTestExample {

    boolean isEven(int n) {
        return n % 2 == 0;
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void testEvenNumbers(int number) {
        assertTrue(isEven(number));
    }
}