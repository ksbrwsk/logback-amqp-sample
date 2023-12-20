package de.ksbrwsk.logback;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class is responsible for configuring RabbitMQ for the application.
 * It sets up the connection, exchange, queue, and binding.
 */
@Configuration
@EnableRabbit
public class RabbitMQConfiguration {

    // The name of the exchange
    private final static String EXCHANGE_NAME = "logs";

    /**
     * This method creates a connection factory for RabbitMQ.
     * It uses the CachingConnectionFactory for efficient connection management.
     *
     * @return A ConnectionFactory instance.
     */
    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory("localhost");
    }

    /**
     * This method creates a topic exchange with the specified name.
     *
     * @return A TopicExchange instance.
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    /**
     * This method creates a RabbitTemplate for sending and receiving messages.
     * It sets the encoding to UTF-8 and enables transactional channels.
     *
     * @return A RabbitTemplate instance.
     */
    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setEncoding("UTF-8");
        rabbitTemplate.setChannelTransacted(true);
        return rabbitTemplate;
    }

    /**
     * This method creates a binding between the queue and the exchange.
     * It uses a wildcard routing key (#) to route all messages to the queue.
     *
     * @return A Binding instance.
     */
    @Bean
    public Binding bindingLogs() {
        return BindingBuilder
                .bind(queueLogs())
                .to(exchange())
                .with("#");
    }

    /**
     * This method creates a durable queue with the specified name.
     *
     * @return A Queue instance.
     */
    @Bean
    public Queue queueLogs() {
        return new Queue("queue-logs", true);
    }

}