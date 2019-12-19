package edu.mum.cs544.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })

public class ApigatewayApplication {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
//    @Bean
//    public SpringConfig getSpringConfig(){
//        return new SpringConfig();
//    }

    public static void main(String[] args) {
        SpringApplication.run(ApigatewayApplication.class, args);
    }

}
