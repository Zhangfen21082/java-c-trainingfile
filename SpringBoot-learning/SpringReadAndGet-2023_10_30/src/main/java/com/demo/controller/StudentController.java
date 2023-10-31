package com.demo.controller;

import com.demo.model.Student;
import com.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class StudentController {
    @Autowired
    @Qualifier(value = "student1")
    private Student student;

    public void sayHello() {
        System.out.println(student);
    }
}
