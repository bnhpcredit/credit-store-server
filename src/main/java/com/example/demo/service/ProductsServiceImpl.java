package com.example.demo.service;

import java.time.LocalDate;
import java.util.UUID;

import com.example.demo.data.CardOffer;
import com.example.demo.data.CreditLimitOffer;
import com.example.demo.data.DigitalGuaranteeOffer;
import com.example.demo.data.LoanOffer;
import com.example.demo.data.ProductOffers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class ProductsServiceImpl implements ProductsService {
    public ProductOffers getProducts(@RequestParam Long partyId) {
   		// call a service in order to get party scores

		// call a service in order to get products offers by scores

        return mockedProductOffers();
    }
    
	private ProductOffers mockedProductOffers() {
		ProductOffers productOffers = new ProductOffers();
		LoanOffer loan = new LoanOffer(1000.0, 10000.0, 1.2, 2.2, 12, 72, LocalDate.now(), 500.01, 1500.56, 1, 1);
		loan.setProductType(1);
		loan.setProductTypeName("Digital Loan");
		loan.setId(generateUUID());
		LoanOffer[] loanOffers = {loan,loan};
		productOffers.setLoanOffers(loanOffers);

		DigitalGuaranteeOffer digitalGuaranteeOffer = new DigitalGuaranteeOffer(1100.0, LocalDate.now(), LocalDate.now());
		digitalGuaranteeOffer.setId(generateUUID());
		digitalGuaranteeOffer.setProductType(2);
		digitalGuaranteeOffer.setProductTypeName("Digital Guarantee");
		DigitalGuaranteeOffer[] digitalGuaranteeOffers = {digitalGuaranteeOffer, digitalGuaranteeOffer};
		productOffers.setDigitalGuaranteeOffers(digitalGuaranteeOffers);

		CreditLimitOffer creditLimitOfferForCard = new CreditLimitOffer(1200.0, LocalDate.now(), LocalDate.now());
		CardOffer cardOffer = new CardOffer(creditLimitOfferForCard);
		cardOffer.setProductSubType(3);
		cardOffer.setProductSubTypeName("Gold Card");
		cardOffer.setProductSubTypeDescription("Gold Corporate Card");
		cardOffer.setId(generateUUID());
		cardOffer.setProductType(3);
		cardOffer.setProductTypeName("Credit Card");
		CardOffer[] cardOffers = {cardOffer, cardOffer};
		productOffers.setCardOffers(cardOffers);

		CreditLimitOffer creditLimitOffer = new CreditLimitOffer(1150.0, LocalDate.now(), LocalDate.now());
		creditLimitOffer.setId(generateUUID());
		creditLimitOffer.setProductType(4);
		creditLimitOffer.setProductTypeName("Credit Limit");
		CreditLimitOffer[] creditLimitOffers = {creditLimitOffer, creditLimitOffer};
		productOffers.setCreditLimitOffers(creditLimitOffers);

		return productOffers;
	}

	private String generateUUID() {
		return UUID.randomUUID().toString();
	}

}
