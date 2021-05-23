package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.UUID;

import javax.websocket.server.PathParam;

import com.example.demo.data.Card;
import com.example.demo.data.CardOffer;
import com.example.demo.data.CreditLimit;
import com.example.demo.data.CreditLimitOffer;
import com.example.demo.data.DigitalGuarantee;
import com.example.demo.data.DigitalGuaranteeOffer;
import com.example.demo.data.LoanOffer;
import com.example.demo.data.ProductOffers;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

@RestController
@RequestMapping("products")
public class ProductsController {

	@Value("${mongodb.uri}")
	private String mongoConnectionUri;

	@GetMapping("health-check")
	public Integer getHealthCheck() {
		return 1;
	}

	@GetMapping("quantity")
	public Long getNumOfProducts() {

		MongoClient mongoClient = MongoClients.create(mongoConnectionUri);
		MongoDatabase database = mongoClient.getDatabase("Bank");
		return database.getCollection("loan products").countDocuments();

	}

	@GetMapping("sanity")
	public String sanity() {
		return "sanity";
	}

	@GetMapping()
	public ProductOffers getProducts(@RequestParam Long partyId) {
		// call a service in order to get party scores

		// call a service in order to get products offers by scores

		return mockeProducts();
	}

	private ProductOffers mockeProducts() {
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
