package edu.mum.cs544.apigateway.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.cs544.apigateway.domain.Cart;
import edu.mum.cs544.apigateway.domain.Product;
import edu.mum.cs544.apigateway.service.CartProxy;
import edu.mum.cs544.apigateway.service.ProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes({"username","userId","itemSize","carts"})
public class CartController {
    @Autowired
    CartProxy cartProxy;

    @Autowired
    ProductProxy productProxy;
    ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/cart")
    public String getAll(@ModelAttribute("userId") String userId, Model model, Cart cart){
        System.out.println("uid enter1:"+userId);
        List<Cart> carts = cartProxy.getAll(Long.parseLong(userId));
        model.addAttribute("cart",carts);
        cartProxy.addCartInfo(Long.parseLong(userId),model);
        System.out.println("size of cart =========="+carts.size());
        return "home";
    }

    @GetMapping("/cart/remove/{id}")
    public String  removeCartItem(@ModelAttribute("userId") Long uid, @PathVariable(name = "id") long id ,Model model){
        cartProxy.delete(id);
        cartProxy.addCartInfo(uid,model);
        return "redirect:/checkout";
    }

    @GetMapping(value = "/cart/add/{productId}")
    public String addToCart(@ModelAttribute("userId") String userId, @PathVariable(name = "productId") long productId, Model model){
        Cart cart = new Cart();
        Product product = productProxy.get(productId);
        cart.setUserId(Long.parseLong(userId));
        System.out.println("UserId" + userId);
        cart.setProductId(productId);
        cart.setProductName(product.getProductName());
        cart.setQuantity(1);
        cart.setRate(product.getPrice());
        cart.setPrice(1 * product.getPrice());
        cartProxy.add(cart);
        Integer cartSize = cartProxy.getCount(Long.parseLong(userId));
        System.out.println("cart size:"+cartSize);
        cartProxy.addCartInfo(Long.parseLong(userId),model);
        return "redirect:/";
    }

    @GetMapping("/checkout")
    public String getAllCart(@ModelAttribute("userId") String userId, Model model, Cart cart){
        System.out.println("userid" + userId);
        //model.addAttribute("cart",cartProxy.getAll(Long.parseLong(userId)));
        cartProxy.addCartInfo(Long.parseLong(userId),model);
        return "checkout";
    }



}
