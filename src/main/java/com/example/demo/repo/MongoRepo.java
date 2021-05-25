package com.example.demo.repo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MongoRepo {


    @Autowired
    private MongoDatabase database;

    public <T> List<T> getGeneric(String collection, Class clazz){

        MongoCollection<T> loanCollection = database.getCollection(collection, clazz);
		Collection<T> coll= loanCollection.find(new Document(), clazz).into(new ArrayList());
        return new ArrayList<T>(coll);
    }




    
}