package com.example.demo.data;

import lombok.Data;

@Data
public class Card extends Product {
    Integer type;
    String typeName;
    CreditLimit limit;
}
