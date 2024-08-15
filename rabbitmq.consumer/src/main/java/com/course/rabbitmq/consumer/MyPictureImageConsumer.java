package com.course.rabbitmq.consumer;

import com.course.rabbitmq.consumer.entity.Picture;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;

import java.io.IOException;

//@Service
public class MyPictureImageConsumer {

    private static final Logger log = LoggerFactory.getLogger(MyPictureImageConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "q.mypicture.image")
    public void listen(String json, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        Picture picture = objectMapper.readValue(json, Picture.class);

        // Generally, it is recommended to use the exception throwing mechanism, because we can forget to do the basicAck
        if (picture.getSize() > 9000) {
            channel.basicReject(tag, false);
//            throw new AmqpRejectAndDontRequeueException("Picture size too large: " + picture.getSize());
        }

        log.info("Processing image: {}", picture);

        channel.basicAck(tag, false);
    }
}
