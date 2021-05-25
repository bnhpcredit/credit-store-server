package com.example.demo.service;


import java.util.List;

import com.example.demo.data.CreditLimitOffer;
import com.example.demo.data.DigitalGuaranteeOffer;
import com.example.demo.data.LoanOffer;
import com.example.demo.data.ProductOffers;
import com.example.demo.repo.MongoRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ProductsServiceImpl implements ProductsService {

	@Value("${mongodb.uri}")
	private String mongoConnectionUri;

	@Autowired
	private MongoRepo repo;

    public ProductOffers getProducts(@RequestParam Long partyId) {
		ProductOffers productOffers = new ProductOffers();
		
		List<LoanOffer> loanOffers = repo.getGeneric("LoanOffers", LoanOffer.class);
		List<DigitalGuaranteeOffer> digitalGuaranteeOffers = repo.getGeneric("DigitalGuaranteeOffers", DigitalGuaranteeOffer.class);
		List<CreditLimitOffer> creditLimitOffers = repo.getGeneric("CreditLimitOffers", CreditLimitOffer.class);

		productOffers.setLoanOffers(loanOffers);
		productOffers.setDigitalGuaranteeOffers(digitalGuaranteeOffers);
		productOffers.setCreditLimitOffers(creditLimitOffers);
	


   		// call a service in order to get party scores

		// call a service in order to get products offers by scores

		return productOffers;

    }

}
