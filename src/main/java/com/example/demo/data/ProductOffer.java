package com.example.demo.data;

import lombok.Data;

@Data
public class ProductOffer {
    String id; //uuid
    Integer productType; // e.g loan/credit card/credit limit...
    String productTypeName;
    String productTypeDescription;
    Integer productSubType; //Enum?
    String productSubTypeName; // Enum?
    String productSubTypeDescription;
}
