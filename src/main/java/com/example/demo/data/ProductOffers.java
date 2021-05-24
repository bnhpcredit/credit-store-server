package com.example.demo.data;

import java.util.List;

import lombok.Data;

@Data
public class ProductOffers {
    List<LoanOffer> loanOffers;
    List<CreditLimitOffer> creditLimitOffers;
    List<CardOffer> cardOffers;
    List<DigitalGuaranteeOffer> digitalGuaranteeOffers;
}
