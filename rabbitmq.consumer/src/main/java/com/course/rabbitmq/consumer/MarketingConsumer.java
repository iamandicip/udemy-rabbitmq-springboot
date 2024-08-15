package com.course.rabbitmq.consumer;

import com.course.rabbitmq.consumer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

//@Service
public class MarketingConsumer {

    private static final Logger logger = LoggerFactory.getLogger(MarketingConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "q.hr.marketing")
    public void Listen(String json) throws JsonProcessingException {
        var employee = objectMapper.readValue(json, Employee.class);
        logger.info("On marketing: {}", employee.toString());
    }
}
