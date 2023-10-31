package com.service;

import com.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class StudentBeans2 {
    @Bean(name={"s1"})
    public Student students() {
        Student student = new Student();
        student.setAge(18);
        student.setId(1);
        student.setName("张三");
        return student;
    }
}
