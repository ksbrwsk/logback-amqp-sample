package de.ksbrwsk.logback;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.awaitility.Awaitility.waitAtMost;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Slf4j
@Import(TestcontainersConfiguration.class)
class ScheduledMessageProducerTest {

    @Autowired
    TestListener testListener;

    @Test
    void runningScheduledMessageProducerFor5Sec() {
        log.info("*** Create and run ScheduledMessageProducer");
        ScheduledMessageProducer producer = new ScheduledMessageProducer();
        producer.createMessage();
        waitAtMost(Duration.ofSeconds(5))
                .untilAsserted(() -> {
                    log.info("*** Test running for 5 sec., received messages: {}", this.testListener.messages.size());
                    assertTrue(this.testListener.messages.size() > 0);
                });
    }

    @TestConfiguration
    static class Config {

        @Bean
        TestListener testListener() {
            return new TestListener();
        }
    }

    static class TestListener {
        private final List<String> messages = new ArrayList<>();

        @RabbitListener(queues = "queue-logs")
        void listen(String data) {
            this.messages.add(data);
        }
    }
}