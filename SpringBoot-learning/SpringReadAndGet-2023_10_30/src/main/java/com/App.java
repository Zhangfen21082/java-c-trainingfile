package com;

import com.demo.controller.StudentController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        StudentController studentController = context.getBean("studentController", StudentController.class);
        studentController.sayHello();
    }
}