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

import com.example.demo.data.Loan;
import com.example.demo.data.Products;
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
	public Products getProducts(@RequestParam Long partyId) {
		Products products = new Products();
		Loan loan = new Loan();
		loan.setProductType(1);
		loan.setProductTypeName("Digital Loan");
		loan.setLoanType(1);
		loan.setStartDate(LocalDate.now());
		loan.setId(UUID.randomUUID().toString());
		products.setLoan(loan);
		return products;

	}

}
