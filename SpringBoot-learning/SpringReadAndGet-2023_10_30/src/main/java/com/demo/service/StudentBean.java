package com.demo.service;

import com.demo.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class StudentBean {
    @Bean
    public Student student1() {
        Student student = new Student();
        student.setAge(18);
        student.setId(1);
        student.setName("张三");
        return student;
    }

    @Bean
    public Student student2() {
        Student student = new Student();
        student.setAge(20);
        student.setId(2);
        student.setName("李四");
        return student;
    }
}
