package com.example.demo123;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class EmailSenderRunner implements CommandLineRunner {

    private final EmailService emailService;

    @Autowired
    public EmailSenderRunner(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void run(String... args) {
        List<String> recipients = Arrays.asList(
                "SatoKatsu1910@gmail.com",
                "Asannnali@gmail.com"
        );

        String subject = "Test Email from Spring Boot";
        String body = "Hello! This is a test email sent automatically from Spring Boot.";

        // Отправка писем каждому адресату
        for (String recipient : recipients) {
            try {
                emailService.sendEmail(recipient, subject, body);
            } catch (Exception e) {
                System.err.println("Failed to send email to " + recipient + ": " + e.getMessage());
            }
        }
    }
}
