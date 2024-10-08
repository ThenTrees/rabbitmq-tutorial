package com.thentrees.rabbitmqtutorial.controller;

import com.thentrees.rabbitmqtutorial.publisher.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class MessageController {

    private final RabbitMQProducer producer;

    // http://localhost:8080/api/v1/publish?message=hello-world!
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        producer.sendMessage(message);
        return ResponseEntity.ok("Send message via RabbitMQ ...");
    }

}
