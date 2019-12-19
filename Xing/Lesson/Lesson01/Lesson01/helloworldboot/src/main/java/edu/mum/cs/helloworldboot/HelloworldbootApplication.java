package edu.mum.cs.helloworldboot;

import edu.mum.cs.helloworldboot.component.MessageDisplay;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HelloworldbootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(HelloworldbootApplication.class, args);
        applicationContext.getBean(MessageDisplay.class).display();
    }

}
