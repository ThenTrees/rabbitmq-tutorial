package com.thentrees.rabbitmqtutorial.publisher;

import com.thentrees.rabbitmqtutorial.dto.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQJsonProducer {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    private final RabbitTemplate rabbitTemplate;

    public void sendJsonMessage(User user) {
        log.info("Send message via rabbitmq: {}", user);
        rabbitTemplate.convertAndSend(exchange, routingJsonKey, user);
    }
}
