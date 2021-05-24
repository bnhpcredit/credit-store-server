package com.example.demo.data;

import java.time.LocalDate;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data()
public class LoanOffer extends ProductOffer {
    
    @BsonId 
    ObjectId idCheck;
    Double minAmount;
    Double maxAmount;
    Double minRate;
    Double maxRate;
    Integer minNumberOfPayments;
    Integer maxNumberOfPayments;
    String firstPaymentDate;
    Double minMonthlyPayment;
    Double maxMonthlyPayment;
    Integer amortizationType;
    Integer loanPurpose;

}
