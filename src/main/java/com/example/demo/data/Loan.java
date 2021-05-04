package com.example.demo.data;

import java.time.LocalDate;

import lombok.Data;

@Data()
public class Loan extends Product {
    Integer loanType;
    Double loanAmount;
    Integer numberOfPayments;
    LocalDate startDate;
    LocalDate endDate;
    LocalDate firstPaymentDate;

}
