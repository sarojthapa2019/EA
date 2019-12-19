package edu.mum.cs544.apigateway.service;

import edu.mum.cs544.apigateway.domain.Product;

import java.util.List;

public interface ProductService {
    public List<Product>getAllProduct();
   public Product get(long id);
    public void add(Product product, String uid);
   public void delete(long id);
   public void update(Product product);
   public List<Product>getProductByCategory(String category);
}
