package com.example.demo.configuration;

import com.mongodb.MongoClientSettings;

import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import org.bson.codecs.configuration.CodecRegistry;


import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Configuration
public class MongoConfig {

    @Value("${mongodb.uri}")
	private String mongoConnectionUri;

    @Bean
    public MongoDatabase mongoDatabase() {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClient	mongoClient = MongoClients.create(mongoConnectionUri);
        MongoDatabase database = mongoClient.getDatabase("Products").withCodecRegistry(pojoCodecRegistry);
        return database;

    }

}
