package com.example.demo.data;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardOffer extends ProductOffer {
    @BsonId 
    ObjectId idCheck;
    CreditLimitOffer limit;
}
