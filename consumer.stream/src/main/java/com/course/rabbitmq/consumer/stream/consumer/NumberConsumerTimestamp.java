package com.course.rabbitmq.consumer.stream.consumer;

import com.rabbitmq.stream.Message;
import com.rabbitmq.stream.MessageHandler;
import lombok.extern.slf4j.Slf4j;

//@Service
@Slf4j
public class NumberConsumerTimestamp {

    //    @RabbitListener(queues = RabbitMqStreamConfig.STREAM_NUMBER, containerFactory = "timestampContainerFactoryOne")
    public void timestampOne(Message message, MessageHandler.Context context) {
        log.info("timestamp 1: {} on timestamp {}", message.getBody(), context.timestamp());
    }

    //    @RabbitListener(queues = RabbitMqStreamConfig.STREAM_NUMBER, containerFactory = "timestampContainerFactoryTwo")
    public void timestampTwo(Message message, MessageHandler.Context context) {
        log.info("timestamp 1: {} on timestamp {}", message.getBody(), context.timestamp());
    }
}
