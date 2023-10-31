package com.service;

import com.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class StudentBeans {
    @Bean(name={"s2"})
    public Student students() {
        Student student = new Student();
        student.setAge(18);
        student.setId(1);
        student.setName("李四");
        return student;
    }
}
