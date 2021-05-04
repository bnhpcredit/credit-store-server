package com.example.demo.data;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DigitalGuarantee extends Product {
    Double amount;
    String firstGuarantorName;
    Long firstGuarantorId;
    String secondGuarantorName;
    Long secondGuarantorId;
    LocalDate startDate;
    LocalDate endDate;
}
