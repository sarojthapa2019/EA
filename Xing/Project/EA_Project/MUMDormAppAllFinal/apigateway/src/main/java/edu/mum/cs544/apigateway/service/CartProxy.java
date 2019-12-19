package edu.mum.cs544.apigateway.service;

import edu.mum.cs544.apigateway.domain.AppEnv;
import edu.mum.cs544.apigateway.domain.Cart;
import edu.mum.cs544.apigateway.domain.PaymentDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import javax.security.auth.login.AppConfigurationEntry;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartProxy implements CartService {
    @Autowired
    private RestTemplate restTemplate;

    private String cartIp = AppEnv.getCartService();//"http://172.19.142.34:8083";//"http://172.19.141.122:8083";
    private final String getAllUrl = cartIp +"/cart/";
    private final String addUrl = cartIp +"/cart/";
    private final String deleteUrl = cartIp +"/cart/remove/{id}";


    @Override
    public List<Cart> getAll(long userId) {
        ResponseEntity<List<Cart>> response =
                restTemplate.exchange(getAllUrl+String.valueOf(userId), HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Cart>>() {
                        });
        return response.getBody();
    }


    @Override
    public void add(Cart cart) {
       restTemplate.postForLocation(addUrl, cart);

    }

    @Override
    public void delete(long id) {
        restTemplate.delete(deleteUrl.replaceFirst("\\{id}",String.valueOf(id)));
    }


    @Override
    public boolean addPayDetail(PaymentDetail pd){
        return restTemplate.postForObject(cartIp+"/paymentDetail/add",pd,Boolean.class);
    }

    @Override
    public List<PaymentDetail> getAllPayDetails() {
        ResponseEntity<List<PaymentDetail>> response =
                restTemplate.exchange(cartIp+"/paymentDetail", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<PaymentDetail>>() {
                        });
        return response.getBody();
    }

    @Override
    public Integer getCount(Long id) {
        return restTemplate.getForObject(cartIp+"/cart/count/"+id,Integer.class);
    }

    @Override
    public void update(Cart c){
        restTemplate.put(addUrl+"/update",c);
    }

    @Override
    public void addCartInfo(Long uid, Model model){
        List<Cart> cartList = new ArrayList<>();
        for(Cart c:getAll(uid)){
            if(!c.isBoughtFlag()){
                cartList.add(c);
            }
        }
        model.addAttribute("itemSize",cartList.size());
        model.addAttribute("carts",cartList);
    }
}
