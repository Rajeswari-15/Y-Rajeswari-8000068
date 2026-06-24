package com.example.springtest.controller;

import com.example.springtest.exception.GlobalExceptionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionTest {

    @Test
    void testHandleNotFound() {

        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        ResponseEntity<String> response =
                handler.handleNotFound(new NoSuchElementException());

        assertEquals(404, response.getStatusCodeValue());
        assertEquals("User not found", response.getBody());
    }
}