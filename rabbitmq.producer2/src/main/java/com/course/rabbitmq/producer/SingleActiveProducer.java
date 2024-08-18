package com.course.rabbitmq.producer;

import com.course.rabbitmq.entity.DummyMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingleActiveProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // this producer works best with the consistent hash exchange
    public void sendDummy() {
        for (int i = 0; i < 10_000; i++) {
            var message = new DummyMessage("Dummy-" + i, i);
            rabbitTemplate.convertAndSend("x.single", "", message);
        }
    }
}
