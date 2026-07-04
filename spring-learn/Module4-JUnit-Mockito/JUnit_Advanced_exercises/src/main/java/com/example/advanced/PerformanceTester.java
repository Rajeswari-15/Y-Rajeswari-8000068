package com.example.advanced;

public class PerformanceTester {

    public void performTask() {
        try {
            Thread.sleep(1000); // simulate processing
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}