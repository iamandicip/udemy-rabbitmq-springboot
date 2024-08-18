package com.course.rabbitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.rabbit.stream.producer.RabbitStreamTemplate;
import org.springframework.stereotype.Service;

@Service
public class StreamHelloProducer {

    @Autowired
    @Qualifier("rabbitStreamTemplateHello")
    private RabbitStreamTemplate rabbitStreamTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendHello(String message) {
        rabbitStreamTemplate.convertAndSend(message);
    }

    public void sendHelloUsingExchange(String message) {
        rabbitTemplate.convertAndSend("x.hello", "rk.hello", message);
    }
}

