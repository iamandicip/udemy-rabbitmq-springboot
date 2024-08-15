package com.course.rabbitmq.consumer;

import com.course.rabbitmq.entity.DummyMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DummyConsumer {

    @RabbitListener(queues = "q.dummy")
    public void listenDummy(DummyMessage dummyMessage){
        log.info("{}", dummyMessage);
    }
}
