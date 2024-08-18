package com.course.rabbitmq.consumer;

import com.course.rabbitmq.entity.DummyMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AnotherDummyConsumer {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "q.auto-dummy", durable = "true"),
            exchange = @Exchange(name = "x.auto-dummy", type = ExchangeTypes.DIRECT, durable = "true"),
            key = "routingKey",
            ignoreDeclarationExceptions = "true"
    ))
    public void listenDummy(DummyMessage dummyMessage) {
        log.info("{}", dummyMessage);
    }
}
