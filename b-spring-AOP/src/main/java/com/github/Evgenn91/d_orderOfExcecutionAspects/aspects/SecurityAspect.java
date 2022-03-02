package com.github.Evgenn91.d_orderOfExcecutionAspects.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
//данной аннотацией мы задаем порядок выполнения аспектов
//тоесть в этом классе аспекты будут выполнятся вторыми(если poin cut совпадет с действием метода)
//а первым выполнятся аспекты под номером 1
//порядок нумерации не выжен(тоесть можно не по порядку цифры использовать)
//но чем меньше число, тем раньше выполнятся аспекты в этом классе
@Order(2)
public class SecurityAspect {

    @Before("com.github.Evgenn91.d_orderOfExcecutionAspects.aspects.MyPointCuts.allGetMethods()")
    public void beforeGetSecurityAdvice(){
        System.out.println("beforeGetSecurityAdvice: проверка прав на получение книги/журнала");
    }
}
