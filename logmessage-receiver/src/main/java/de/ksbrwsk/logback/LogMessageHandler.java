package de.ksbrwsk.logback;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LogMessageHandler {

    private static final String AMQP_APP_ID = "amqp_appId";
    private static final String AMQP_LEVEL = "level";
    private static final String AMQP_TIMESTAMP = "timestamp";

    @RabbitListener(queues = "queue-logs")
    public void handleLogMessage(Message<String> message) {
        log.info("Message received: {} - {} - {} - {}",
                message.getHeaders().get(AMQP_APP_ID),
                message.getHeaders().get(AMQP_LEVEL),
                message.getHeaders().get(AMQP_TIMESTAMP),
                message.getPayload());
    }
}