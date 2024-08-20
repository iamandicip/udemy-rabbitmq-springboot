package com.course.rabbitmq.consumer.stream.consumer;

import com.rabbitmq.stream.MessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NumberConsumerNext {

    //    @RabbitListener(queues = RabbitMqStreamConfig.STREAM_NUMBER, containerFactory = "nextContainerFactoryOne")
    public void nextOne(Message message, MessageHandler.Context context) {
        log.info("next 1: {} on offset {}", message.getBody(), context.offset());
    }

    //    @RabbitListener(queues = RabbitMqStreamConfig.STREAM_NUMBER, containerFactory = "nextContainerFactoryTwo")
    public void nextTwo(Message message, MessageHandler.Context context) {
        log.info("next 2: {} on offset {}", message.getBody(), context.offset());
    }
}
