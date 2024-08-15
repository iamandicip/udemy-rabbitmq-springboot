package com.course.rabbitmq.consumer;

import com.course.rabbitmq.entity.DummyMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class MultiplePrefetchConsumer {

    @RabbitListener(queues = "q.transaction", concurrency = "2")
    public void listenTransaction(DummyMessage message) throws InterruptedException {
        log.info("Consuming transaction: {}", message);

        TimeUnit.SECONDS.sleep(1);
    }

    @RabbitListener(queues = "q.scheduler", concurrency = "2", containerFactory = "prefetchOneContainerFactory")
    public void listenScheduler(DummyMessage message) throws InterruptedException {
        log.info("Consuming scheduler: {}", message);

        TimeUnit.SECONDS.sleep(60);
    }
}
