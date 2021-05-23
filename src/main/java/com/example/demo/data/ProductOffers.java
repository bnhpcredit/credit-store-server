package com.example.demo.data;

import lombok.Data;

@Data
public class ProductOffers {
    LoanOffer[] loanOffers;
    CreditLimitOffer[] creditLimitOffers;
    CardOffer[] cardOffers;
    DigitalGuaranteeOffer[] digitalGuaranteeOffers;
}
