package com.course.rabbitmq.consumer;

import com.course.rabbitmq.entity.DummyMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.util.concurrent.TimeUnit;

//@Service
@Slf4j
public class DummyPrefetchConsumer {

    @RabbitListener(queues = "q.dummy", concurrency = "2")
    public void listenDummy(DummyMessage dummyMessage) throws InterruptedException {
        log.info("{}", dummyMessage);
        TimeUnit.SECONDS.sleep(20);
    }
}
