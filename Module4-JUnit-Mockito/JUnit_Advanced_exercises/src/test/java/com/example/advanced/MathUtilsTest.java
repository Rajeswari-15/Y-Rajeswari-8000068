package com.example.advanced;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    MathUtils math = new MathUtils();

    @Test
    void testAdd() {
        assertEquals(5, math.add(2, 3));
    }
}
