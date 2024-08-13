package com.course.rabbitmq.producer.scheduler;

import com.course.rabbitmq.producer.client.RabbitmqClient;
import com.course.rabbitmq.producer.entity.RabbitmqQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

//@Service
public class RabbitmqScheduler {

    private static final Logger logger = LoggerFactory.getLogger(RabbitmqScheduler.class);

    @Autowired
    private RabbitmqClient rabbitmqClient;

    @Scheduled(fixedDelay = 90000)
    void sweepDirtyQueues() {
        try {
            var dirtyQueues = rabbitmqClient.getAllQueues().stream()
                    .filter(RabbitmqQueue::isDirty)
                    .toList();
            dirtyQueues.forEach(queue -> logger.info("Queue {} has {} unprocessed messagss", queue.getName(), queue.getMessages()));
        } catch (Exception ex) {
            logger.warn("Cannot sweep queues: {}", ex.getMessage());
        }
    }
}
