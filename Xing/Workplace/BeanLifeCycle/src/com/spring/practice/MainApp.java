package com.spring.practice;
import com.spring.practice.HelloWorld;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        helloWorld.getMessage();

        HelloUS helloUS = (HelloUS) applicationContext.getBean("helloUS");
        helloUS.getMessage();
        helloUS.getMessage2();
//        applicationContext.registerShutdownHook();
    }

}
