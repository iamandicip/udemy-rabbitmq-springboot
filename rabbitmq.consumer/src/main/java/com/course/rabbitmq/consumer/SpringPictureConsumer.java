package com.course.rabbitmq.consumer;

import com.course.rabbitmq.consumer.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

//@Service
public class SpringPictureConsumer {

    public static final Logger logger = LoggerFactory.getLogger(SpringPictureConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "q.spring.image.work")
    public void listenImage(String message) throws IOException {
        var picture = objectMapper.readValue(message, Picture.class);

        logger.info("Consuming image: {}", picture);

        if (picture.getSize() > 9000) {
            throw new IOException("Image " + picture.getName() + " size too large: " + picture.getSize());
        }

        logger.info("Processing image: {}", picture);
    }

    @RabbitListener(queues = "q.spring.vector.work")
    public void listenVector(String message) throws JsonProcessingException {
        var picture = objectMapper.readValue(message, Picture.class);

        logger.info("Consuming vector: {}", picture);
        logger.info("Processing vector: {}", picture);
    }
}

