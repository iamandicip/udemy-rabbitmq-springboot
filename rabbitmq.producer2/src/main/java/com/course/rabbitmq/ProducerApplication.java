package com.course.rabbitmq;

import com.course.rabbitmq.producer.SingleActiveProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

//    @Autowired
//    private DummyProducer dummyProducer;

//    @Autowired
//    private MultiplePrefetchProducer multiplePrefetchProducer;

//    @Autowired
//    private InvoiceProducer invoiceProducer;

    @Autowired
    private SingleActiveProducer singleActiveProducer;


    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        singleActiveProducer.sendDummy();

//        for (int i = 0; i < 200; i++) {
//            var invoiceNumber = "INV-" + (i % 60);
//            var invoice = new InvoiceCreatedMessage(ThreadLocalRandom.current()
//                    .nextDouble(1, 200), LocalDate.now(), "USD", invoiceNumber);
//            invoiceProducer.sendInvoiceCreated(invoice);
//        }
//
//        var randomInvoiceNumber = "INV-" + ThreadLocalRandom.current().nextInt(100, 200);
//        var invoiceCreatedMessage = new InvoiceCreatedMessage(144.4, LocalDate.now(), "USD", randomInvoiceNumber);
//        invoiceProducer.sendInvoiceCreated(invoiceCreatedMessage);
//
//        randomInvoiceNumber = "INV-" + ThreadLocalRandom.current().nextInt(200, 300);
//        var randomPaymentNumber = "PAY-" + ThreadLocalRandom.current().nextInt(1000, 2000);
//        var invoicePaidMessage = new InvoicePaidMessage(randomInvoiceNumber, LocalDate.now(), randomPaymentNumber);
//        invoiceProducer.sendInvoicePaid(invoicePaidMessage);
//
//        randomInvoiceNumber = "INV-" + ThreadLocalRandom.current().nextInt(300, 400);
//        var invoiceCancelledMessage = new InvoiceCancelledMessage(randomInvoiceNumber, LocalDate.now(), "Invoice cancelled");
//        invoiceProducer.sendInvoiceCancelled(invoiceCancelledMessage);

//        multiplePrefetchProducer.simulateTransaction();
//        multiplePrefetchProducer.simulateScheduler();
//
//        System.out.println("All data sent");

//        var dummyMessage = new DummyMessage("Content", 1);
//        dummyProducer.sendDummy(dummyMessage);

//        for (int i = 0; i < 500; i++) {
//            var dummyMessage = new DummyMessage("Content " + i, 1);
//            dummyProducer.sendDummy(dummyMessage);

//            TimeUnit.SECONDS.sleep(1);
//        }
    }
}
