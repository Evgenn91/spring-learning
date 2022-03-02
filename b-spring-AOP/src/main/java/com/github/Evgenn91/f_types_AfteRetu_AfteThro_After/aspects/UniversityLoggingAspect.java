package com.github.Evgenn91.f_types_AfteRetu_AfteThro_After.aspects;

import com.github.Evgenn91.f_types_AfteRetu_AfteThro_After.objects.Student;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoggingAdvice(){
        System.out.println("beforeGetStudentsLoggingAdvice: логируем получение " +
                "списка студентов перед методом getStudents");
    }

    /**
     * тип AfterReturning
     * выполняется только после нормального окончания метода с основной логикой,
     * но до присвоения результата этого метода какой либо переменной
     * (с его помощью возможно изменять возвращаемый результат)
     */
//    @AfterReturning("execution(* getStudents())")
//    public void afterReturningGetStudentsLoggingAdvice(){
//        System.out.println("afterReturningGetStudentsLoggingAdvice: логируем получение " +
//                "списка студентов после методом getStudents");
//    }

    //НЕ ПРИМЕНЯТЬ ЭТО НА ПРАКТИКЕ!!!!!!!!!

    //изменим результат метода(до этого он выдавал нам 1го студента)
    //изменим имя у первого в списке студента
    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students") /* students должен совпадать со students во входном параметре*/
    public void afterReturningGetStudentsLoggingAdvice(List<Student> students){
        Student firstStudent = students.get(0);
        String nameSur = "новое имя";
        firstStudent.setSurName(nameSur);
    }
}
