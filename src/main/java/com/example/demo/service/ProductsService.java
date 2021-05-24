package com.example.demo.service;

import com.example.demo.data.ProductOffers;

import org.springframework.web.bind.annotation.RequestParam;

public interface ProductsService {
    public ProductOffers getProducts(@RequestParam Long partyId);
}
