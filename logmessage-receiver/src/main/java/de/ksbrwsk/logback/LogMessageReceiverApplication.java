package de.ksbrwsk.logback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the main class for the LogMessageReceiver application.
 * It uses Spring Boot's @SpringBootApplication annotation for automatic configuration.
 */
@SpringBootApplication
public class LogMessageReceiverApplication {

    /**
     * This is the main method which serves as an entry point for the application.
     * It runs the SpringApplication's run method using the LogMessageReceiverApplication class and command line arguments.
     *
     * @param args Command line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(LogMessageReceiverApplication.class, args);
    }
}