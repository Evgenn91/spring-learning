package com.github.Evgenn91.b_workWithPointCut.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    //сделаем, чтобы Advice сработал только перед методом класса UnivercityLibrary(необходимо прописать весь путь к классу)
    @Before("execution(public void com.github.Evgenn91.b_workWithPointCut.odjects.UniversityLibrary.getBook())") /* в скобках - это POINT CUT */
    public void beforeGetBookAdvice(){
        System.out.println("вызвался перед методом(void) getBook() (без входных параметров)");
    }

    //сделаем, чтобы Advice сработал перед любым методом, который начинается на get
    @Before("execution(public void get*())") /* в скобках - это POINT CUT */
    public void beforeAllMethodsGet(){
        System.out.println("вызвался перед каждым методом (void), начинающимся с get(без входных параметров)");
    }

    //сделаем, чтобы Advice сработал перед методом returnBook(), который может что то вернут: значение как void так и какое то значение(* поставим)
    @Before("execution(public * returnBook())")
    public void beforeAllMethWhichReturns(){
        System.out.println("вызвался перед методом(void, public ....), который возвращает String значение(без входных параметров)");
    }
    /**p.s. если хотим чтобы срабатало на этот метод, но при этом он может быть protected, public
     * то делаем так:
     * execution(* returnBook()) - public просто убираем!!!
     */

    //сделаем, чтобы Advice сработал перед любым методом
    @Before("execution(* *())")
    public void allMethods(){
        System.out.println("вызвался перед любым методом(void, public .....)(без входных параметров)");
    }

    //сделаем, чтобы Advice сработал перед методом getBook() у которого есть 1 входной параметр String
    @Before("execution(public void getBook(String))")
    public void getMethodWithParameter(){
        System.out.println("вызвался перед методом(void) getBook с 1 входным параметром - String");
    }

    //сделаем, чтобы Advice сработал перед методом с любым названием(метод void) у которого есть 1 входной параметр любого типа
    @Before("execution(public void *(*))")
    public void getAllMethodsWithOneParameter(){
        System.out.println("вызвался перед любым методом(метод void!!!) с 1 любым входным параметром");
    }

    //сделаем, чтобы Advice сработал перед методом с любым названием у которого есть любое колличество входных параметров(даже ниодного параметра)
    @Before("execution(public void *(..))")
    public void getAllMethodsWithAllParameter(){
        System.out.println("вызвался перед любым методом(void) с любым колличеством вх параметром (даже когда их нет)");
    }

    //сделаем, чтобы Advice сработал перед методом getBook с входныи параметром в виде объекта Book
    @Before("execution(public void getBook(com.github.Evgenn91.b_workWithPointCut.odjects.Book))")
    public void beforeGetBookWithParameterBook(){
        System.out.println("вызвался перед методом(void) getBook с входным параметров Book");
    }



    /**
     * point cut - это выражение, описывающее где должен быть применен Advice
     */

    /**
     * для написания point cut мы используем шаблон:
     * execution( modifier-pattern ? RERUTN-TYPE-PATTERN  declaring-type-pattern ? METHOD-NAME-PATTERN(PARAMETERS-PATTERN) throws-pattern ? )
     * что с большой буквы - это обязательный параметр
     * ? - означает, что элементы перед ним могут быть а могут не быть
     */
}
