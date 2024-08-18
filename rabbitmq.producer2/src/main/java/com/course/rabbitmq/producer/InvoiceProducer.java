package com.course.rabbitmq.producer;

import com.course.rabbitmq.entity.InvoiceCancelledMessage;
import com.course.rabbitmq.entity.InvoiceCreatedMessage;
import com.course.rabbitmq.entity.InvoicePaidMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceProducer {

    private static final String EXCHANGE_NAME = "x.invoice";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendInvoiceCreated(InvoiceCreatedMessage invoiceCreatedMessage) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, invoiceCreatedMessage.getInvoiceNumber(), invoiceCreatedMessage);
    }

    public void sendInvoicePaid(InvoicePaidMessage invoicePaidMessage) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, invoicePaidMessage.getInvoiceNumber(), invoicePaidMessage);
    }

    public void sendInvoiceCancelled(InvoiceCancelledMessage invoiceCancelledMessage) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, invoiceCancelledMessage.getInvoiceNumber(), invoiceCancelledMessage);
    }
}
