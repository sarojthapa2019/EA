package edu.mum.cs544.apigateway.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Blob;

@Data
@Getter
@Setter
@NoArgsConstructor
public class Product {
    private long id;
    @NotEmpty
    private String productName;
    @NotEmpty
    private String productCategory;
    private boolean status;
    private double price;
    private int quantity;
    private String productDetail;
   @NotBlank
    private String image;
    private long userId;

    public Product(@NotEmpty String productName, @NotEmpty String productCategory, boolean status, @NotEmpty double price, @NotNull int quantity, String productDetail, String image, long userId) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.status = status;
        this.price = price;
        this.quantity = quantity;
        this.productDetail = productDetail;
        this.image = image;
        this.userId = userId;
    }
}
