package com.github.Evgenn91.e_JointPoin.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointCuts {

    @Pointcut("execution(* add*(..))")
    public void allAddMethods(){}
}
