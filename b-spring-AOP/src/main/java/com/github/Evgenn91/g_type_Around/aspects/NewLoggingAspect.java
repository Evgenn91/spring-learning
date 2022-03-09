package com.github.Evgenn91.g_type_Around.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


/**
 * тип Around -
 * выполняется до и после метода с основной логикой
 * Самый многофункциональный, что можно:
 * 1) произвести какие-либо действия до работы target метода;
 * 2) произвести какие-либо действия после работы target матода;
 * 3) получить результат работы target метода/изменить его;
 * 4) предпринять какие-либо действия, если из target метода выбрасывается исключение;
 */

@Component
@Aspect
public class NewLoggingAspect {

    /**
     * при выборе Around мы берем на себя ответственность
     * сами запускать target метод
     */
    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("вызвался перед");
        long begin = System.currentTimeMillis();/* для замера времени выполнения метода*/
        Object targetMethodResult = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("время выполненя метода returnBook: " + (end - begin) +" мс");
        System.out.println("вызвался после");
        return targetMethodResult;
    }

    /**
     * работа с исключениями в Around
     * действия, если из target метода выбасывается исключение:
     * 1) ничего не делать - исключение дальше пробросится
     * 2) обрабатывать исключение (в отличие от AfterThrowing)
     */
    @Around("execution(public String returnMagazine())")
    public Object aroundReturnMagazineLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Object targetMethodResult = null;
        try{
            targetMethodResult = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("произошло исключение в методе returnMagazine: "+e.toString());
            throw e;/* обязательно пробрасываем исключение дальше, т.к. мы его можем скрыть в этом методе, а это плохо!!!*/
        }
        return targetMethodResult;
    }
}
