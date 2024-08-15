package com.course.rabbitmq.consumer;

import com.course.rabbitmq.consumer.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

//@Service
public class PictureImageConsumer2 {

    private static final Logger log = LoggerFactory.getLogger(PictureImageConsumer2.class);

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = {"q.picture.image", "q.picture.filter", "q.picture.vector", "q.picture.log"})
    public void listen(Message message) throws JsonProcessingException {
        var json = new String(message.getBody());
        Picture picture = objectMapper.readValue(json, Picture.class);
        log.info("Consuming: {} with routing key: {}", picture, message.getMessageProperties().getReceivedRoutingKey());
    }
}
