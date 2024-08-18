package com.course.rabbitmq.consumer;

import com.course.rabbitmq.entity.InvoiceCreatedMessage;
import com.course.rabbitmq.entity.InvoicePaidMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

//@Service
@RabbitListener(queues = "q.invoice")
@Slf4j
public class InvoiceConsumer {

    @RabbitHandler
    public void handleInvoiceCreated(InvoiceCreatedMessage invoiceCreatedMessage) {
        log.info("Invoice created: {}", invoiceCreatedMessage);
    }

    @RabbitHandler
    public void handleInvoicePaid(InvoicePaidMessage invoicePaidMessage) {
        log.info("Invoice paid: {}", invoicePaidMessage);
    }

    @RabbitHandler(isDefault = true)
    public void handleDefault(Object message) {
        log.info("Default handler: {}", message);
    }
}

