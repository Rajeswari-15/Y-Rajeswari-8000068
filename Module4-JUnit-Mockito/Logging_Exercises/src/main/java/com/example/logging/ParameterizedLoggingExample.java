package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger =
            LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {

        String user = "Raji";
        int orderId = 101;

        // Parameterized logging (VERY IMPORTANT in interviews)
        logger.info("User {} placed order {}", user, orderId);

        logger.warn("Low stock for product: {}", "Laptop");

        try {
            int result = 10 / 0;
        } catch (Exception e) {
            logger.error("Exception occurred: {}", e.getMessage());
        }
    }
}