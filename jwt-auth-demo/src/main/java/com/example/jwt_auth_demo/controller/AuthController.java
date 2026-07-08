package com.example.jwt_auth_demo.controller;


import com.example.jwt_auth_demo.dto.JwtResponse;

import com.example.jwt_auth_demo.dto.LoginRequest;

import com.example.jwt_auth_demo.security.JwtService;


import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping
public class AuthController {



    private final AuthenticationManager authenticationManager;


    private final JwtService jwtService;



    public AuthController(
            AuthenticationManager authenticationManager,
            JwtService jwtService) {

        this.authenticationManager = authenticationManager;

        this.jwtService = jwtService;

    }




    @PostMapping("/login")
    public JwtResponse login(
            @RequestBody LoginRequest request) {



        authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(

                        request.getUsername(),

                        request.getPassword()

                )

        );



        String token =

                jwtService.generateToken(

                        request.getUsername()

                );



        return new JwtResponse(token);


    }



}