package com.example.oauth2_login_demo;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String home() {
        return "Welcome to OAuth2 Login Demo";
    }

    @GetMapping("/user")
    public Authentication user(Authentication authentication) {
        return authentication;
    }
}