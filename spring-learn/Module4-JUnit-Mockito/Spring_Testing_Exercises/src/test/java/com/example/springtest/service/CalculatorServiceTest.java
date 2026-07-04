package com.example.springtest.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    CalculatorService calculatorService = new CalculatorService();

    @Test
    void testAdd() {
        assertEquals(5, calculatorService.add(2, 3));
    }
}