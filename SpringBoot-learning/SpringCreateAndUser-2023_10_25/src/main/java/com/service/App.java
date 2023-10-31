package com.service;

import com.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // 创建Spring上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        // 获取指定Bean
        Student student = context.getBean("s2", Student.class);
        // 使用Bean
        System.out.println(student);

    }
}
