package com.course.rabbitmq.producer.stream.config;

import com.rabbitmq.stream.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.rabbit.stream.config.SuperStream;
import org.springframework.rabbit.stream.producer.RabbitStreamTemplate;

@Configuration
public class RabbitmqSuperStreamConfig {

    public static final int SUPER_STREAM_NUMBER_PARTITIONS = 3;
    public static final String SUPER_STREAM_NUMBER_NAME = "s.super.number";

    @Bean
    SuperStream superStreamNumber() {
        return new SuperStream(SUPER_STREAM_NUMBER_NAME, SUPER_STREAM_NUMBER_PARTITIONS);
    }

    @Bean(name = "superStreamNumberTemplate")
    RabbitStreamTemplate superStreamNumberTemplate(Environment env) {
        var template = new RabbitStreamTemplate(env, SUPER_STREAM_NUMBER_NAME);

        template.setSuperStreamRouting(message -> message.getProperties().getMessageIdAsString());

        return template;
    }

}
