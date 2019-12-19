package edu.mum.cs544.apigateway.controller;

import edu.mum.cs544.apigateway.domain.Cart;
import edu.mum.cs544.apigateway.domain.PaymentDetail;
import edu.mum.cs544.apigateway.domain.Product;
import edu.mum.cs544.apigateway.service.CartService;
import edu.mum.cs544.apigateway.service.PaymentService;
import edu.mum.cs544.apigateway.service.ProductService;
import edu.mum.cs544.apigateway.service.UserService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/payment")
@SessionAttributes({"username","userId","itemSize","carts"})
public class PaymentController {
    private final String base = "/payment";

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String pay(Model model){
        model.addAttribute("amount",100.0);
        model.addAttribute("payView","/payment/pay");
        return "payenable";
    }

    @GetMapping("/pay")
    public RedirectView pay(@ModelAttribute("userId") String userId, Model model){
        Double total = 0.0;
        String product="";

        for(Cart c:cartService.getAll(Long.parseLong(userId))){
            total+=c.getPrice();
            product = product+"/"+c.getProductName()+"(sold by :"+userService.getUser(productService.get(c.getProductId()).getUserId()).getEmail()+")";
        }

        System.out.println("Total:" + total);
        model.addAttribute("total", total);
        String url = paymentService.makePayment(total, product);
        System.out.println(url);
        RedirectView redir = new RedirectView();
        redir.setUrl(url);
        return redir;
    }
    @GetMapping("/cancel")
    public String cancelled(){
        return "pay_cancel";
    }

    @GetMapping("/success")
    public String success(@ModelAttribute("userId") String userId, @RequestParam String paymentId, @RequestParam String token, @RequestParam String PayerID, Model model){
        System.out.println("Payment ID:"+paymentId);
        model.addAttribute("paymentId",paymentId);
        model.addAttribute("token",token);
        model.addAttribute("PayerID",PayerID);

        PaymentDetail pd = new PaymentDetail();
        try {
            pd = paymentService.logTransaction(paymentId,token,PayerID);
            if(cartService.addPayDetail(pd))
                System.out.println("Payment Details added");
            model.addAttribute("message"," Thank you for shopping at MUM-Dorm App");
        } catch (JSONException e) {
            e.printStackTrace();
            model.addAttribute("message",e.getLocalizedMessage());
        }

        for(Cart c:cartService.getAll(Long.parseLong(userId))){
            c.setBoughtFlag(true);
            cartService.update(c);
            Product product = productService.get(c.getProductId());
            product.setStatus(false);
            productService.update(product);
        }

        model.addAttribute("pd",pd);
        cartService.addCartInfo(Long.parseLong(userId),model);
        return "pay_success";
    }

    @GetMapping("/paymentDetails")
    public String getAllPaymentDetails(Model model){
        model.addAttribute("payDetails",cartService.getAllPayDetails());
        return "allPayments";
    }


}
