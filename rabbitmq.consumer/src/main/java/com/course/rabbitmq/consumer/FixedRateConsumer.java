package com.course.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

//@Service
public class FixedRateConsumer {

    public static final Logger logger = LoggerFactory.getLogger(FixedRateConsumer.class);

    @RabbitListener(queues = "course.fixedrate", concurrency = "3-7")
    public void listen(String message) throws InterruptedException {
        logger.info("Thread {} consuming: {}", Thread.currentThread().getName(), message);
        TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(2000));
    }
}


