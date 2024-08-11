package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.entity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final List<String> SOURCES = List.of("mobile", "web");

    private static final List<String> TYPES = List.of("jpg", "png", "svg");

    @Autowired
    private PictureProducer2 pictureProducer;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            var picture = new Picture();
            picture.setName("Picture " + i);

            picture.setType(TYPES.get(i % TYPES.size()));
            picture.setSource(SOURCES.get(i % SOURCES.size()));

            // random size
            picture.setSize(ThreadLocalRandom.current().nextLong(1, 10000));

            pictureProducer.sendMessage(picture);
        }
    }
}
