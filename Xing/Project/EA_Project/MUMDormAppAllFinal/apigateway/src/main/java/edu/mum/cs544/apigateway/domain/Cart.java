package edu.mum.cs544.apigateway.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class Cart {

    private long id;
    private long userId;
    private long productId;
    private String productName;
    private int quantity;
    private double rate;
    private double price;
    private boolean boughtFlag;
}
