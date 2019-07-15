package edu.mum.cs544.paycheck.Controller;

import edu.mum.cs544.paycheck.Domain.Account;
import edu.mum.cs544.paycheck.Domain.Result;
import edu.mum.cs544.paycheck.Service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api")
public class PayController {

    @Autowired
    private PayService payService;

    @PostMapping("/Mum")
    public RedirectView pay(@RequestBody Account account){
        if(payService.transact(account))
            return new RedirectView("/success");
        else{
            return new RedirectView("/fail");
        }
    }

    @GetMapping("/success")
    public Result success(){
        return new Result("Success","From Mock Service");
    }

    @GetMapping("/fail")
    public Result fail(){
        return new Result("Fail", "From Mock Service");
    }

    @GetMapping("/")
    public Result testFail(){
        return new Result("Fail", "From Mock Service");
    }

    @GetMapping("")
    public Result testFail2(){
        return new Result("Fail", "From Mock Service");
    }
}
