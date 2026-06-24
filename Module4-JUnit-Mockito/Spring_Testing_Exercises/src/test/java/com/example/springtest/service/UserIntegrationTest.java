package com.example.springtest.service;

import com.example.springtest.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserIntegrationTest {

    @Autowired
    UserService userService;

    @Test
    void testFullFlow() {

        User user = new User();
        user.setName("Raji");

        User savedUser = userService.saveUser(user);

        assertNotNull(savedUser);
        assertNotNull(savedUser.getName());
        assertEquals("Raji", savedUser.getName());
    }
}