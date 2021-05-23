package com.example.demo.data;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DigitalGuaranteeOffer extends ProductOffer {
    Double amount;
    LocalDate startDate;
    LocalDate endDate;
}
