package com.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
        HelloWorld helloWorld = applicationContext.getBean(HelloWorld.class);
        helloWorld.setMessage("Hello");
        helloWorld.getMessage();
    }
}
