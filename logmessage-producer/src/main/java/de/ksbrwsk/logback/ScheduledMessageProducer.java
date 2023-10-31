package de.ksbrwsk.logback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
@Slf4j
public class ScheduledMessageProducer {

    private AtomicLong counter = new AtomicLong(1L);

    @Scheduled(fixedRate = 500)
    public void createMessage() {
        log.info("Message No. {}", this.counter.getAndIncrement());
    }
}
