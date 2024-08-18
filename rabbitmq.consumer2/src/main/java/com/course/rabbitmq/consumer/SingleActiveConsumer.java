package com.course.rabbitmq.consumer;

import com.course.rabbitmq.entity.DummyMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.util.concurrent.TimeUnit;

//@Service
@Slf4j
public class SingleActiveConsumer {

    // this consumer works best with the consistent hash exchange
    @RabbitListener(queues = "q.single", concurrency = "5")
    public void listenDummy(DummyMessage message) throws InterruptedException {
        log.info("{}", message);
        TimeUnit.SECONDS.sleep(1);
    }

}
