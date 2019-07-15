package edu.mum.cs544.paycheck;

import edu.mum.cs544.paycheck.Service.MockPayService;
import edu.mum.cs544.paycheck.Service.PayService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaycheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaycheckApplication.class, args);
    }

    @Bean
    public PayService getPayService(){
        return new MockPayService();
        //return new PayServiceImpl();
    }
}
