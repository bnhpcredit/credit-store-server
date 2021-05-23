package com.example.demo.data;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
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
