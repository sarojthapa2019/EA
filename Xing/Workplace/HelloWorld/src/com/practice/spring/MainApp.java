package com.practice.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld helloWorldObj = (HelloWorld) applicationContext.getBean("helloWorld");
        helloWorldObj.setMessage("First message");
        helloWorldObj.getMessage();

        HelloWorld helloWorldObj2 = (HelloWorld) applicationContext.getBean("helloWorld");
        helloWorldObj2.setMessage("SecondMessage");
        helloWorldObj2.getMessage();
        helloWorldObj.getMessage();
    }
}
