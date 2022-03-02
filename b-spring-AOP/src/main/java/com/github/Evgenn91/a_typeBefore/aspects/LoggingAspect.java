package com.github.Evgenn91.a_typeBefore.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * создаем класс, отвечающий за сквозную функциональность
 */

@Component
//добавление этой аннотации говорит, что это необычный класс а Aspect
//и Spring к этому классу будет относится по другому
@Aspect
public class LoggingAspect {
    /**
     * @Before - это Advice тип
     *
     * execution(public void getBook()) - это POINT CUT !!!!!,
     * т.е. выражение, которое читается как:
     * перед выполнением(потому что @Before) метода getBook() сделать
     * то, что у нас внутри метода beforeGetBookAdvice()(этот метод называем как хотим)
     */
    @Before("execution(public void getBook())") /* в скобках - это POINT CUT */
    public void beforeGetBookAdvice(){
        System.out.println("попытка получить книгу");
    }


    /**
     * Типы Advice типов:
     * 1) Before - выполняется до метода с основной логикой
     * 2) After returning - выполняется только после нормального окончания метода с основной логикой
     * 3) After throwing - выполняется после окончания метода с основной логикой(только если было выброшено исключение)
     * 4) After/After finally - выполняется после окончания метода с основной логикой
     * 5) Around - выполняется до и после метода с основной логикой
     */

    /**
     * Advice - это термин из AOP.
     * это метод, который находится в аспект классе и
     * который определяет, что должно произойти при вызове метода
     * в нашем случае(метод getBook())
     */

}
