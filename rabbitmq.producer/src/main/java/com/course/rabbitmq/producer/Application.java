package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private EmployeeJsonProducer employeeJsonProducer;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 5; i++) {
            var employee = new Employee("emp" + i, "Employee " + i, LocalDate.now());
            employeeJsonProducer.sendMessage(employee);
        }
    }
}
