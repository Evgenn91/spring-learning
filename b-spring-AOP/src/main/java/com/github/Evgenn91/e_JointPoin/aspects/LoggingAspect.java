package com.github.Evgenn91.e_JointPoin.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.OptionalDataException;

@Component
@Aspect
@Order(1)
public class LoggingAspect {

    @Before("com.github.Evgenn91.e_JointPoin.aspects.MyPointCuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint){ /*в параметре метода мы можем прописать JoinPoint!!!!!*/
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Object[] arguments = joinPoint.getArgs();
        System.out.println("1 аргумент из аспекта: "+arguments[0]);
    }

    /**
     * прописам joinpoin в параметре, мы получаем доступ к информации о сигнатуре и
     * параметрах метода(это те параметры, которые добавляются в метод бизнес логики)
     * с бизнес логикой так мы можем писать в лог информацию о самом методе
     */


    /**
     * Methodsignatire из этого объекта можно получить следующее:
     * methodSignature.getMethod() - выводит полное имя метода
     * methodSignature.getReturnType() - получит тип returnType
     * methodSignature.getName() - выводит само имя метода
     */

    /**
     * можно написать условие, если хотим из одного метода получить параметры, а из другого нет
     * if(methodSignature.getName().equals("addBook")){...}
     */
}
