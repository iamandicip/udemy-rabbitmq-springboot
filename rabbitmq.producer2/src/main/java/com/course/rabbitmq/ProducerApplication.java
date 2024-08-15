package com.course.rabbitmq;

import com.course.rabbitmq.producer.MultiplePrefetchProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

//    @Autowired
//    private DummyProducer dummyProducer;

    @Autowired
    private MultiplePrefetchProducer multiplePrefetchProducer;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        multiplePrefetchProducer.simulateTransaction();
        multiplePrefetchProducer.simulateScheduler();

        System.out.println("All data sent");
        
//        var dummyMessage = new DummyMessage("Content", 1);
//        dummyProducer.sendDummy(dummyMessage);

//        for (int i = 0; i < 500; i++) {
//            var dummyMessage = new DummyMessage("Content " + i, 1);
//            dummyProducer.sendDummy(dummyMessage);

//            TimeUnit.SECONDS.sleep(1);
//        }
    }
}
