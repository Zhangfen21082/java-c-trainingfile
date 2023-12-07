package com.example.demo.demos.app;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect // 切面类
@Component
public class UserAspect {
    // 切点：配置拦截规则
    // 返回类型可以是任意类型，UserController下的所有方法，参数可以是任何类型和数量
    @Pointcut("execution(* com.example.demo.demos.controller.UserController.*(..))")
    public void pointcut() {}

    // 环绕通知：注意具有返回值和参数
    @Around("pointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("进入环绕通知");
        Object obj = null;

        // 执行目标方法
        obj = joinPoint.proceed();
        System.out.println("退出环绕通知");
        return obj;
    }

}
