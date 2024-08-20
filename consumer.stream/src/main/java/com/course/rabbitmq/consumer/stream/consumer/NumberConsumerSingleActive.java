package com.course.rabbitmq.consumer.stream.consumer;

import com.course.rabbitmq.consumer.stream.config.RabbitMqStreamConfig;
import com.rabbitmq.stream.Message;
import com.rabbitmq.stream.MessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.qpid.proton.amqp.messaging.Data;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.util.concurrent.TimeUnit;

//@Service
@Slf4j
public class NumberConsumerSingleActive {

    @RabbitListener(queues = RabbitMqStreamConfig.STREAM_NUMBER, containerFactory = "singleActiveContainerFactoryOne")
    public void singleActiveOne(Message message, MessageHandler.Context context) throws InterruptedException {
        var data = (Data) message.getBody();
        log.info("single active 1: {}, offset: {}", data.getValue(), context.offset());
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
