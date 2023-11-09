package com.demo.component;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanLifeComponent implements BeanNameAware {
    @Override
    public void setBeanName(String s) {
        System.out.println("执行了setBeanName" + s);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("执行了@PostConstruct");
    }

    public void init() {
        System.out.println("执行了init-method方法");
    }

    @PreDestroy
    public void preDestory() {
        System.out.println("执行了preDestory");
    }
}
