package edu.mum;

import edu.mum.component.MessageDisplay;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class HelloWorld {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfiguration.class);
        applicationContext.getBean(MessageDisplay.class).display();
    }

}
