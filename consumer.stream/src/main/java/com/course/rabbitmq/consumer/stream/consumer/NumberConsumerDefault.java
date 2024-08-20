package com.course.rabbitmq.consumer.stream.consumer;

import com.rabbitmq.stream.Message;
import lombok.extern.slf4j.Slf4j;

//@Service
@Slf4j
public class NumberConsumerDefault {

    //    @RabbitListener(queues = RabbitMqStreamConfig.STREAM_NUMBER)
    public void listenNumberOne(String message) {
        log.info("default listen string: {}", message);
    }

    //    @RabbitListener(queues = RabbitMqStreamConfig.STREAM_NUMBER)
    public void listenNumberTwo(Message message) {
        log.info("default listen message: {}", message);
    }
}
