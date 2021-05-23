package com.example.demo.data;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data()
public class Loan extends Product {
    Double amount;
    Double rate;
    Integer numberOfPayments;
    LocalDate startDate;
    LocalDate endDate;
    LocalDate firstPaymentDate;
    Double monthlyPayment;
}
