package com.example.demo.data;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data()
public class LoanOffer extends ProductOffer {
    Double minAmount;
    Double maxAmount;
    Double minRate;
    Double maxRate;
    Integer minNumberOfPayments;
    Integer maxNumberOfPayments;
    LocalDate firstPaymentDate;
    Double minMonthlyPayment;
    Double maxMonthlyPayment;
    Integer amortizationType;
    Integer loanPurpose;

}
