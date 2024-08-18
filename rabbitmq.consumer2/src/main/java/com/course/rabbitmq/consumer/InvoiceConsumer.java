package com.course.rabbitmq.consumer;

import com.course.rabbitmq.entity.InvoiceCancelledMessage;
import com.course.rabbitmq.entity.InvoiceCreatedMessage;
import com.course.rabbitmq.entity.InvoicePaidMessage;
import com.course.rabbitmq.entity.PaymentCancelStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Service
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

    @RabbitHandler
    @SendTo("x.invoice.cancel/")
    public PaymentCancelStatus handleInvoiceCanceled(InvoiceCancelledMessage message) {
        var randomStatus = ThreadLocalRandom.current().nextBoolean();

        return new PaymentCancelStatus(randomStatus, LocalDate.now(), message.getInvoiceNumber());
    }
}

