package com.example.demo.demos.app;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // 切面类
@Component
public class UserAspect {
    // 切点：配置拦截规则
    // 返回类型可以是任意类型，UserController下的所有方法，参数可以是任何类型和数量
    @Pointcut("execution(* com.example.demo.demos.controller.UserController.*(..))")
    public void pointcut() {}

    // 通知：定义通知

    @Before("pointcut()") // 针对pointcut这个拦截规则
    public void beforeAdvice() {
        System.out.println("执行了前置通知");
    }

    @After("pointcut()") // 针对pointcut这个拦截规则
    public void afterAdvice() {
        System.out.println("执行了后置通知");
    }
}
