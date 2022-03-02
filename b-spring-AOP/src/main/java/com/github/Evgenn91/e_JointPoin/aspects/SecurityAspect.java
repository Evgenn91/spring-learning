package com.github.Evgenn91.e_JointPoin.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class SecurityAspect {
    @Before("com.github.Evgenn91.e_JointPoin.aspects.MyPointCuts.allAddMethods()")
    public void beforeAddSecutiryAdvice(){
        System.out.println("beforeAddSecutiryAdvice: проверка прав на добавление книги/журнала");
    }
}
