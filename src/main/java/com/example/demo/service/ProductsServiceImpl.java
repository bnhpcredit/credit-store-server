package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.demo.data.CardOffer;
import com.example.demo.data.CreditLimitOffer;
import com.example.demo.data.DigitalGuaranteeOffer;
import com.example.demo.data.LoanOffer;
import com.example.demo.data.ProductOffers;
import com.example.demo.repo.MongoRepo;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class ProductsServiceImpl implements ProductsService {

	@Value("${mongodb.uri}")
	private String mongoConnectionUri;

	@Autowired
	private MongoRepo repo;

	//must springify repo to make it more generic
    public ProductOffers getProducts(@RequestParam Long partyId) {
		ProductOffers productOffers = new ProductOffers();
		
		List<LoanOffer> loanOffers = repo.getLoanOfferCollection();
		List<DigitalGuaranteeOffer> digitalGuaranteeOffers = repo.getDigitalGuaranteeCollection();
		List<CreditLimitOffer> creditLimitOffers = repo.getCreditLimitCollection();

		productOffers.setLoanOffers(loanOffers);
		productOffers.setDigitalGuaranteeOffers(digitalGuaranteeOffers);
		productOffers.setCreditLimitOffers(creditLimitOffers);
	


   		// call a service in order to get party scores

		// call a service in order to get products offers by scores

		return productOffers;

    }

}
