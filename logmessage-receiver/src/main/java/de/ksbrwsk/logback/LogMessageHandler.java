package de.ksbrwsk.logback;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * This class is responsible for handling log messages.
 * It listens to a RabbitMQ queue and processes incoming messages.
 */
@Component
@Slf4j
public class LogMessageHandler {

    // Constants for the message headers
    private static final String AMQP_APP_ID = "amqp_appId";
    private static final String AMQP_LEVEL = "level";
    private static final String AMQP_TIMESTAMP = "timestamp";

    /**
     * This method is a RabbitMQ listener that gets triggered when a new message arrives in the "queue-logs" queue.
     * It logs the message headers and payload.
     *
     * @param message The incoming message. It's expected to have headers for the application ID, log level, and timestamp.
     */
    @RabbitListener(queues = "queue-logs")
    public void handleLogMessage(Message<String> message) {
        log.info("Message received: {} - {} - {} - {}",
                message.getHeaders().get(AMQP_APP_ID),
                message.getHeaders().get(AMQP_LEVEL),
                message.getHeaders().get(AMQP_TIMESTAMP),
                message.getPayload());
    }
}