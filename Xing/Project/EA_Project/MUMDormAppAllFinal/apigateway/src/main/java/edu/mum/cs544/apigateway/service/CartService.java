package edu.mum.cs544.apigateway.service;

import edu.mum.cs544.apigateway.domain.Cart;
import edu.mum.cs544.apigateway.domain.PaymentDetail;
import edu.mum.cs544.apigateway.domain.Product;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public interface CartService {
    public List<Cart>getAll(long userId);
    public void add(Cart cart);
    public void delete(long id);
    public boolean addPayDetail(PaymentDetail pd);
    public List<PaymentDetail> getAllPayDetails();
    public Integer getCount(Long id);
    public void update(Cart c);
    public void addCartInfo(Long uid, Model model);
}
