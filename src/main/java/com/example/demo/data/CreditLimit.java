package com.example.demo.data;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CreditLimit extends Product {
    Double amount;
    LocalDate startDate;
    LocalDate endDate;
}
