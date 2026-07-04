package com.example.springtest.service;

import com.example.springtest.entity.User;
import com.example.springtest.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    void testGetUserById() {

        User user = new User(1L, "Raji");

        when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals("Raji", result.getName());

        verify(userRepository).findById(1L);
    }

    @Test
    void testUserNotFound() {

        when(userRepository.findById(99L))
                .thenReturn(Optional.empty());

        User result = userService.getUserById(99L);

        assertNull(result);
    }
}