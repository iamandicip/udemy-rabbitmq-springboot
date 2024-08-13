package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final List<String> SOURCES = List.of("mobile", "web");

    private static final List<String> TYPES = List.of("jpg", "png", "svg");

    private static final List<String> COLORS = List.of("white", "red", "green");

    private static final List<String> MATERIALS = List.of("wood", "plastic", "steel");

//    @Autowired
//    private MyPictureProducer pictureProducer;

//    @Autowired
//    private FurnitureProducer furnitureProducer;

//    @Autowired
//    private RetryPictureProducer retryPictureProducer;

    @Autowired
    private RetryEmployeeJsonProducer retryEmployeeJsonProducer;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        for (int i = 0; i < 10; i++) {
//            var furniture = new Furniture();
//            furniture.setName("Furniture " + i);
//            furniture.setColor(COLORS.get(i % COLORS.size()));
//            furniture.setMaterial(MATERIALS.get(i % MATERIALS.size()));
//
//            furnitureProducer.sendMessage(furniture);
//        }
//
//        for (int i = 0; i < 10; i++) {
//            var picture = new Picture();
//            picture.setName("Picture " + i);
//
//            picture.setType(TYPES.get(i % TYPES.size()));
//            picture.setSource(SOURCES.get(i % SOURCES.size()));
//
//            // random size
//            picture.setSize(ThreadLocalRandom.current().nextLong(9001, 10000));
//
//            retryPictureProducer.sendMessage(picture);
//        }

        for (int i = 0; i < 10; i++) {
            var emp = new Employee("Employee-" + i, null, LocalDate.now());

            retryEmployeeJsonProducer.sendMessage(emp);
        }
    }
}
