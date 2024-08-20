package com.course.rabbitmq.consumer.stream.consumer;

import com.rabbitmq.stream.Message;
import com.rabbitmq.stream.MessageHandler;
import lombok.extern.slf4j.Slf4j;

//@Service
@Slf4j
public class NumberConsumerAbsolute {

    //    @RabbitListener(queues = RabbitMqStreamConfig.STREAM_NUMBER, containerFactory = "absoluteContainerFactoryOne")
    public void absoluteOne(Message message, MessageHandler.Context context) {
        log.info("absolute 1: {} on offset {}", message.getBody(), context.offset());
    }

    //    @RabbitListener(queues = RabbitMqStreamConfig.STREAM_NUMBER, containerFactory = "absoluteContainerFactoryTwo")
    public void absoluteTwo(Message message, MessageHandler.Context context) {
        log.info("absolute 2: {} on offset {}", message.getBody(), context.offset());
    }

}
