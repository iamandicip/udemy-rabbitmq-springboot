package com.course.rabbitmq.producer;

import com.course.rabbitmq.entity.DummyMessage;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class ReliableProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    private void registerCallback() {
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (correlationData == null) {
                return;
            }
            if (ack) {
                log.info("Message with correlation {} is published", correlationData.getId());
            } else {
                log.warn("Invalid exchange. Message with correlation {} is not published", correlationData.getId());
            }
        });

        rabbitTemplate.setReturnsCallback(returned -> {
            log.info("Return callback");
            if (returned.getReplyText() != null && returned.getReplyText().equalsIgnoreCase("NO ROUTE")) {
                var id = returned.getMessage().getMessageProperties().getHeader("spring_returned_message_correlation").toString();
                log.warn("Invalid routing key for id: {}", id);
            }
        });
    }

    public void sendMessageWithInvalidRoutingKey(DummyMessage message) {
        var correlationData = new CorrelationData(UUID.randomUUID().toString());

        rabbitTemplate.convertAndSend("x.dummy", "invalidRoutingKey", message, correlationData);
    }

    public void sendMessageToInvalidExchange(DummyMessage message) {
        var correlationData = new CorrelationData(UUID.randomUUID().toString());

        rabbitTemplate.convertAndSend("invalidExchange", "", message, correlationData);
    }
}

