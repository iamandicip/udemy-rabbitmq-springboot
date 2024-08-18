package com.course.rabbitmq.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentCancelStatus {
    private boolean canceled;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate cancelDate;

    private String invoiceNumber;
}
