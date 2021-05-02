package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

@RestController
@RequestMapping(value = "products")
public class ProductsController {

	 @Value("${mongodb.uri}") 
	 private String mongoConnectionUri;
	 
	 @GetMapping(value = "health-check")
	 public Integer getHealthCheck() {
		return 1;
	 }
	 
	@GetMapping()
	public Long getNumOfProducts() {
	
	    MongoClient mongoClient = MongoClients.create(mongoConnectionUri);
		MongoDatabase database = mongoClient.getDatabase("Bank");
		return database.getCollection("loan products").countDocuments();
		
	}
	
}
