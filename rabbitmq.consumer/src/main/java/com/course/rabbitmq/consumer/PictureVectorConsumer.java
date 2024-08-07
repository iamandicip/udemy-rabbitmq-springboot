package com.course.rabbitmq.consumer;

import com.course.rabbitmq.consumer.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

//@Service
public class PictureVectorConsumer {

    private static final Logger log = LoggerFactory.getLogger(PictureVectorConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "q.picture.vector")
    public void listen(String json) throws JsonProcessingException {
        Picture picture = objectMapper.readValue(json, Picture.class);
        log.info("On vector: {}", picture);
    }
}
