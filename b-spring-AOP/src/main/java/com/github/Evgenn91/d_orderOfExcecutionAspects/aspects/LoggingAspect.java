package com.github.Evgenn91.d_orderOfExcecutionAspects.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
//данной аннотацией мы задаем порядок выполнения аспектов
//тоесть в этом классе аспекты будут выполнятся первыми(если poin cut совпадет с действием метода)
//а потом выполнятся аспекты под номером 2 или выше (если нету номера 2)
//порядок нумерации не важен(тоесть можно не по порядку цифры использовать)
//но чем меньше число, тем раньше выполнятся аспекты в этом классе
@Order(1)
public class LoggingAspect {
    @Before("com.github.Evgenn91.d_orderOfExcecutionAspects.aspects.MyPointCuts.allGetMethods()")
    public void beforeGetLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice: логгирование перед получение книги/журнала");
    }
}
