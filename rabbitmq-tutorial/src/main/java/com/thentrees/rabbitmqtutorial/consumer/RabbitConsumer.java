package com.thentrees.rabbitmqtutorial.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitConsumer {

    private static final Logger log = LoggerFactory.getLogger(RabbitConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consumer(String message) {
        log.info("Received msg: {}", message);
    }

}
