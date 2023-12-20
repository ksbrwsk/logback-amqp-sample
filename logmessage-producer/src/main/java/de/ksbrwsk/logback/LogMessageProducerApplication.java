package de.ksbrwsk.logback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * This is the main class for the LogMessageProducer application.
 * It uses Spring Boot's @SpringBootApplication annotation for automatic configuration.
 * It also uses the @EnableScheduling annotation to enable support for scheduled tasks.
 */
@SpringBootApplication
@EnableScheduling
public class LogMessageProducerApplication {

    /**
     * This is the main method which serves as an entry point for the application.
     * It runs the SpringApplication's run method using the LogMessageProducerApplication class and command line arguments.
     *
     * @param args Command line arguments passed to the application.
     */
    public static void main(String... args) {
        SpringApplication.run(LogMessageProducerApplication.class, args);
    }
}