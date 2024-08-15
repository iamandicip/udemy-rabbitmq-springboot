package com.course.rabbitmq.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Bean
    ObjectMapper objectMapper() {
        return JsonMapper.builder().findAndAddModules().build();
    }

    @Bean
    Jackson2JsonMessageConverter converter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    RabbitListenerContainerFactory<SimpleMessageListenerContainer> prefetchOneContainerFactory(
            SimpleRabbitListenerContainerFactoryConfigurer factoryConfigurer, ConnectionFactory connectionFactory) {
        var factory = new SimpleRabbitListenerContainerFactory();
        factoryConfigurer.configure(factory, connectionFactory);

        factory.setPrefetchCount(1);
        return factory;
    }
}
