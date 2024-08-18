package com.course.rabbitmq.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqSchemaConfig {

//    @Bean
//    FanoutExchange fanoutExchange() {
//        return new FanoutExchange("x.another-dummy", true, false, null);
//    }
//
//    @Bean
//    Queue queue() {
//        return new Queue("q.another-dummy");
//    }
//
//    @Bean
//    Binding binding() {
////        return new Binding("q.another-dummy", Binding.DestinationType.QUEUE, "x-another-dummy", "", null);
//        return BindingBuilder.bind(queue())
//                .to(fanoutExchange());
//    }

    @Bean
    Declarables createRabbitMqSchema() {
        var fanoutExchange = new FanoutExchange("x.another-dummy", true, false, null);
        var queue = new Queue("q.another-dummy");
        var binding = BindingBuilder.bind(queue).to(fanoutExchange);
        return new Declarables(
                fanoutExchange,
                queue,
                binding
        );
    }
}
