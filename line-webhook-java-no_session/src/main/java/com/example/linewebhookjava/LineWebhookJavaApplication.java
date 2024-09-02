package com.example.linewebhookjava;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LineWebhookJavaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LineWebhookJavaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Hello World from CommandLineRunner");
    }
}
