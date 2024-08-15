package com.course.rabbitmq;

import com.course.rabbitmq.entity.DummyMessage;
import com.course.rabbitmq.producer.DummyProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

    @Autowired
    private DummyProducer dummyProducer;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        var dummyMessage = new DummyMessage("Content", 1);
//        dummyProducer.sendDummy(dummyMessage);

        for (int i = 0; i < 10_000; i++) {
            var dummyMessage = new DummyMessage("Content " + i, 1);
            dummyProducer.sendDummy(dummyMessage);

            TimeUnit.SECONDS.sleep(1);
        }
    }
}
