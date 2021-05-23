package com.example.demo.data;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreditLimitOffer extends ProductOffer {
    Double amount;
    LocalDate startDate;
    LocalDate endDate;
}
