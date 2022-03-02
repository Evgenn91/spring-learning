package com.github.Evgenn91.d_orderOfExcecutionAspects.aspects;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
//данной аннотацией мы задаем порядок выполнения аспектов
//тоесть в этом классе аспекты будут выполнятся 3ми(если poin cut совпадет с действием метода)
//а потом выполнятся аспекты под номером 4 или выше
//порядок нумерации не важен(тоесть можно не по порядку цифры использовать)
//но чем меньше число, тем раньше выполнятся аспекты в этом классе
@Order(3)
public class ExceptionHandlingAspect {

    @Before("com.github.Evgenn91.d_orderOfExcecutionAspects.aspects.MyPointCuts.allGetMethods()")
    public void beforeGetExceptionHandlingAdvice(){
        System.out.println("beforeGetLoggingAdvice: проверка на ошибки перед получением книги/журнала");
    }
}
