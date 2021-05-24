package com.example.demo.data;

import java.time.LocalDate;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DigitalGuaranteeOffer extends ProductOffer {
    @BsonId 
    ObjectId idCheck;
    Double amount;
    String startDate;
    String endDate;
}
