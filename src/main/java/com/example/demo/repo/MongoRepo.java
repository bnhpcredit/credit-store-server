package com.example.demo.repo;
import com.example.demo.data.CreditLimitOffer;
import com.example.demo.data.DigitalGuaranteeOffer;
import com.example.demo.data.LoanOffer;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import java.util.List;


@Component
public class MongoRepo {

    @Value("${mongodb.uri}")
	private String mongoConnectionUri;

    private CodecRegistry pojoCodecRegistry;
    private MongoClient mongoClient;
    private MongoDatabase database;


    //must springify this class
    private void initMongoConnection(){
        pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		mongoClient = MongoClients.create(mongoConnectionUri);
	    database = mongoClient.getDatabase("Products").withCodecRegistry(pojoCodecRegistry);

    }

    //must make generic

    public List<LoanOffer> getLoanOfferCollection(){
        initMongoConnection();

        MongoCollection<LoanOffer> loanCollection = database.getCollection("LoanOffers", LoanOffer.class);
		List<LoanOffer> loanOffers = loanCollection.find(new Document(), LoanOffer.class).into(new ArrayList<LoanOffer>());
        return loanOffers;

    }

    public List<DigitalGuaranteeOffer> getDigitalGuaranteeCollection(){
        initMongoConnection();

        MongoCollection<DigitalGuaranteeOffer> digitalGuaranteeOffersCollection = database.getCollection("DigitalGuaranteeOffers", DigitalGuaranteeOffer.class);
		List<DigitalGuaranteeOffer> digitalGuaranteeOffers = digitalGuaranteeOffersCollection.find(new Document(), DigitalGuaranteeOffer.class).into(new ArrayList<DigitalGuaranteeOffer>());
        return digitalGuaranteeOffers;

    }

    public List<CreditLimitOffer> getCreditLimitCollection(){
        initMongoConnection();

        MongoCollection<CreditLimitOffer> creditLimitOfferscollection = database.getCollection("CreditLimitOffers", CreditLimitOffer.class);
		List<CreditLimitOffer> creditLimitOffers = creditLimitOfferscollection.find(new Document(), CreditLimitOffer.class).into(new ArrayList<CreditLimitOffer>());
        return creditLimitOffers;

    }


    
}