package com.rmq.example.publisher.controller;

import com.rmq.example.publisher.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/publish")
public class Publisher {

    @Value("${rabbitmq.queue.name}")
    private String queueName;

    @Autowired
    private PublisherService publisherService;

    @PostMapping(value = "/text")
    public void publishText(@RequestBody String text) {
        System.out.println("Sending message: " + text);
        publisherService.publisherTextMessage(text, queueName);
    }

    @PostMapping(value = "/json")
    public void publishJson(@RequestBody String text) {
        publisherService.publisherJsonMessage(text, queueName);
        System.out.println("Sending message: \n" + text);
    }

}
