package com.example.advanced;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderedTests {

    @Test
    @Order(1)
    void loginTest() {
        System.out.println("Login Test Executed");
    }

    @Test
    @Order(2)
    void dashboardTest() {
        System.out.println("Dashboard Test Executed");
    }

    @Test
    @Order(3)
    void logoutTest() {
        System.out.println("Logout Test Executed");
    }
}