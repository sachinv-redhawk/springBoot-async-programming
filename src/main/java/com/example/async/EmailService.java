package com.example.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Async("threadPoolTaskExecutor")
    public void sendEmail() {
        System.out.println("Starting email sending process on thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000); // Simulate a long-running task
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Email sent successfully!");
    }
}
