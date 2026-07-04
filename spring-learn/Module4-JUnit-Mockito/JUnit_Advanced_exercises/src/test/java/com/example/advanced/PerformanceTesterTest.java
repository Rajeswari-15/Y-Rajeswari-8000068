package com.example.advanced;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class PerformanceTesterTest {

    PerformanceTester tester = new PerformanceTester();

    @Test
    void testTimeout() {

        assertTimeout(Duration.ofSeconds(2), () -> {
            tester.performTask();
        });
    }
}
