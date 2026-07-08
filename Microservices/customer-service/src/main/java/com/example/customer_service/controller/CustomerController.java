package com.example.customer_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/customer")

    public String customerHome() {

        return "Welcome to Customer Service";

    }

    @GetMapping("/customer/details")

    public String customerDetails() {

        return "Customer Name : Raji\nCustomer Id : 101";

    }

}