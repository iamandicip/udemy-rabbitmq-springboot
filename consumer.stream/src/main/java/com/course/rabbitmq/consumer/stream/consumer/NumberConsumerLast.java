package com.course.rabbitmq.consumer.stream.consumer;

import com.rabbitmq.stream.MessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NumberConsumerLast {

    //    @RabbitListener(queues = RabbitMqStreamConfig.STREAM_NUMBER, containerFactory = "lastContainerFactoryOne")
    public void lastOne(Message message, MessageHandler.Context context) {
        log.info("last 1: {} on offset {}", message.getBody(), context.offset());
    }

    //    @RabbitListener(queues = RabbitMqStreamConfig.STREAM_NUMBER, containerFactory = "lastContainerFactoryTwo")
    public void lastTwo(Message message, MessageHandler.Context context) {
        log.info("last 2: {} on offset {}", message.getBody(), context.offset());
    }
}
