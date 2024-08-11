package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureProducer2 {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendMessage(Picture picture) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(picture);
        StringBuilder sb = new StringBuilder();

        // 1st word is "mobile" or "web" (picture source)
        sb.append(picture.getSource());
        sb.append(".");

        // 2nd word is "large" or "small" based on picture size
        sb.append(picture.getSize() > 4000 ? "large" : "small");
        sb.append(".");

        // 3rd word is picture type
        sb.append(picture.getType());

        var routingKey = sb.toString();

        rabbitTemplate.convertAndSend("x.picture2", routingKey, json);
    }

}
