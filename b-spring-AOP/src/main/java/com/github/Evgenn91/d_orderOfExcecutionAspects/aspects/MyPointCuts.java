package com.github.Evgenn91.d_orderOfExcecutionAspects.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointCuts {
    @Pointcut("execution(* get*())")
    public void allGetMethods(){}
}
