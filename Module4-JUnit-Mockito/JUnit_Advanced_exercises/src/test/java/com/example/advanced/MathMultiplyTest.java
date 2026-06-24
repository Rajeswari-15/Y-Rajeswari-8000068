package com.example.advanced;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathMultiplyTest {

    MathUtils math = new MathUtils();

    @Test
    void testMultiply() {
        assertEquals(6, math.multiply(2, 3));
    }
}