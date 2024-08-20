package com.course.rabbitmq.consumer.stream.consumer;

import com.course.rabbitmq.consumer.stream.config.RabbitMqStreamConfig;
import com.rabbitmq.stream.MessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

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
