package com.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TextEditorConfig.class);
        TextEditor textEditor = applicationContext.getBean(TextEditor.class);
        textEditor.spellCheck();
    }
}
