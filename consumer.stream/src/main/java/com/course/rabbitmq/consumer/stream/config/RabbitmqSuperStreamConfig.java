package com.course.rabbitmq.consumer.stream.config;

import com.rabbitmq.stream.Environment;
import com.rabbitmq.stream.OffsetSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.rabbit.stream.listener.StreamListenerContainer;

import java.util.concurrent.TimeUnit;

@Configuration
@Slf4j
public class RabbitmqSuperStreamConfig {

    @Bean
    StreamListenerContainer superStreamNumberContainer() {
        var env = Environment.builder().maxConsumersByConnection(1).build();
        var container = new StreamListenerContainer(env);

        container.setConsumerCustomizer((id, builder) -> builder.offset(OffsetSpecification.first()));
        container.superStream("s.super.number", "my-super-stream-number-consumer");
        container.setupMessageListener(message -> {
            log.info(new String(message.getBody()));
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        return container;
    }
}
