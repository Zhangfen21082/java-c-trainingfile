package com.example.springbootfirst2023_11_12;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("student")
@Getter
@Setter
@ToString
public class Student {
    private int id;
    private String name;
    private int age;
}
