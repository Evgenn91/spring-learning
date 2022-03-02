package com.github.Evgenn91.c_declaringPoinCut.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspect {

    /**
     * у нас есть в аспекта:
     * @Before("execution(* get*())")
     *  public void beforeGetLoggingAdvice(){}
     *
     * @Before("execution(* get*())")
     * public void beforeGetSecurityAdvice(){}
     *
     * делают разные вещи, но в одних и тех же методах(у них одинаковый point cut)
     * можно создать 1 point cut и использовать его много раз
     */

    @Pointcut("execution(* get*())")
    private void pointcut_reference(){} /*можно сделать public, тогда можно использовать в других классах аспектах*/

    //используемый ранее созданный point cut
    @Before("pointcut_reference()")
    public void beforeGetLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice: попытка получить книгу/журнал");
    }

    //используемый ранее созданный point cut
    @Before("pointcut_reference()")
    public void beforeGetSecurityAdvice(){
        System.out.println("beforeGetSecurityAdvice: проверка прав на получение книги/журнала");
    }

    //делаем point cut, на срабатывание перед всеми методами начинающимися на get в классе UniversityLibrary
    @Pointcut("execution(* com.github.Evgenn91.c_declaringPoinCut.odjects.UniversityLibrary.get*())")
    private void allGetMethodFromUniLibrary(){}

    @Before("allGetMethodFromUniLibrary()")
    public void beforeNewGetLoggingAdvice(){
        System.out.println("beforeNewGetLoggingAdvice: попытка получить книгу/журнал из класса UniversityLibrary");
    }

    //делаем point cut, на срабатывание перед всеми методами начинающимися на return в классе UniversityLibrary
    @Pointcut("execution(* com.github.Evgenn91.c_declaringPoinCut.odjects.UniversityLibrary.return*())")
    private void allReturnMethodsFromUniLibrary(){}

    @Before("execution(* allReturnMethodsFromUniLibrary())")
    public void beforeReturnLoggingAdvice(){
        System.out.println("beforeNewGetLoggingAdvice: попытка вернуть книгу/журнал из класса UniversityLibrary");
    }

    /**
     * теперь необходимо, чтобы перед всеми методами
     * начинающимися на get и return класса UniversityLibrary
     * мы делали что то одно
     * Нам нужно объединить 2 point cut-а для этого
     * это делается с помощью логических операторов(||,&&,!)
     */

    @Pointcut("allGetMethodFromUniLibrary() || allReturnMethodsFromUniLibrary()")
    private void allGetAndReturnMethodsFromUniLibrary(){}

    @Before("allGetAndReturnMethodsFromUniLibrary()")
    public void beforeGetAndReturnLoggingAdvice(){
        System.out.println("beforeGetAndReturnLoggingAdvice: попытка вернуть и получить книгу/журнал из класса UniversityLibrary");
    }

    /**
     * создаем point cut, который подходит для всех методов, кроме метода returnMagazine()
     */

    //сначала создаем point cut на все мотоды класса UniversityLibrary
    @Pointcut("execution(* com.github.Evgenn91.c_declaringPoinCut.odjects.UniversityLibrary.*(..))")
    private void allMethodsFromUniLibrary(){}

    //теперь создадим point cut, где только метод выбирается, который нам не нужен (метод returnMagazine())
    @Pointcut("execution(public void com.github.Evgenn91.c_declaringPoinCut.odjects.UniversityLibrary.returnMagazine())")
    private void returnMagazineFromUniLibrary(){}

    //и теперь сделаем poin cut, который нам нужен из 2ух верхних pointcut-ов и логических операторов
    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
    private void allMethodExceptReturnMagazineFromUniLibrary(){}

    @Before("allMethodExceptReturnMagazineFromUniLibrary()")
    public void beforeAllMethodsWithoutreturnMagazine(){
        System.out.println("срабатывает перед всеми методами кроме метода returnMagazine()");
    }

}
