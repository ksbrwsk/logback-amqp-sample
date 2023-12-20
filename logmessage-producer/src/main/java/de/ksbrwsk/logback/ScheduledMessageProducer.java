package de.ksbrwsk.logback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * This class is responsible for producing log messages at a fixed rate.
 * It uses Spring's @Scheduled annotation to schedule the task.
 */
@Component
@Slf4j
public class ScheduledMessageProducer {

    // A counter for the messages
    private final AtomicLong counter = new AtomicLong(1L);

    /**
     * This method creates a log message every 500 milliseconds.
     * It uses the @Scheduled annotation to schedule the task at a fixed rate.
     */
    @Scheduled(fixedRate = 500)
    public void createMessage() {
        log.info("Message No. {}", this.counter.getAndIncrement());
    }
}