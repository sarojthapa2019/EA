package com.spring.practice;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InitHelloWorld implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("Before Initialization: " + s);
        return  o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("After Initialization: "+ s);
        return o;
    }
}
