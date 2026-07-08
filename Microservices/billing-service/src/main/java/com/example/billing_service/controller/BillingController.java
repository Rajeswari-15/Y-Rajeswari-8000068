package com.example.billing_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingController {

    @GetMapping("/billing")
    public String billingHome() {

        return "Welcome to Billing Service";

    }

    @GetMapping("/billing/details")
    public String billingDetails() {

        return """
                Bill Number : 1001
                Customer : Raji
                Amount : ₹75,000
                Status : PAID
                """;

    }

}