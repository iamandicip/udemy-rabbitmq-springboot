package com.course.rabbitmq.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitmqScheduler {

    @Autowired
    private RabbitListenerEndpointRegistry registry;

    @Scheduled(cron = "0 49 22 * * *")
    public void stopAll() {
        registry.getListenerContainers().forEach(messageListenerContainer -> {
            log.info("Stopping container {}", messageListenerContainer.getMessageListener());
            messageListenerContainer.stop();
        });
    }

    @Scheduled(cron = "1 50 22 * * *")
    public void startAll() {
        registry.getListenerContainers().forEach(messageListenerContainer -> {
            log.info("Starting container {}", messageListenerContainer.getMessageListener());
            messageListenerContainer.start();
        });
    }
}
