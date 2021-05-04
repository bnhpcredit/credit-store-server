package com.example.demo.data;

import lombok.Data;

@Data
public class Products {
    Loan loan;
    CreditLimit creditLimit;
    Card card;
    DigitalGuarantee digitalGuarantee;
}
