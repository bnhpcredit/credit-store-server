package com.example.demo.controller;

import com.example.demo.data.ProductOffers;
import com.example.demo.service.ProductsService;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductsController {

	@Value("${mongodb.uri}")
	private String mongoConnectionUri;

	@Autowired
	ProductsService productsService;

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
		return productsService.getProducts(partyId);
	}

}
