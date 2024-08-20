package com.course.rabbitmq.consumer.stream.consumer;

import com.course.rabbitmq.consumer.stream.config.RabbitMqStreamConfig;
import com.rabbitmq.stream.MessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NumberConsumerFirst {

    //    @RabbitListener(queues = RabbitMqStreamConfig.STREAM_NUMBER, containerFactory = "firstContainerFactoryOne")
    public void firstOne(Message message, MessageHandler.Context context) {
        log.info("first 1: {} on offset {}", message.getBody(), context.offset());
    }

    //        @RabbitListener(queues = RabbitMqStreamConfig.STREAM_NUMBER, containerFactory = "firstContainerFactoryTwo")
    public void firstTwo(Message message, MessageHandler.Context context) {
        log.info("first 2: {} on offset {}", message.getBody(), context.offset());
    }

    @RabbitListener(queues = RabbitMqStreamConfig.STREAM_NUMBER, containerFactory = "firstContainerFactoryThree")
    public void firstThree(Message message, MessageHandler.Context context) {
        log.info("first 3: {} on offset {}", message.getBody(), context.offset());

        context.storeOffset();
    }
}
