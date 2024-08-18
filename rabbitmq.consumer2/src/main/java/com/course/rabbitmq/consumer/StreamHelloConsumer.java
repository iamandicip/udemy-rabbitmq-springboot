package com.course.rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StreamHelloConsumer {

    @RabbitListener(queues = "s.hello")
    public void listenHello(String message) {
        log.info("Consuming from stream: {}", message);
    }
}
