package com.service;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
		AnnotationConfigApplicationContext myApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserInterface userInterface = (UserInterface) myApplicationContext.getBean("userService");
        userInterface.test();
    }
}
