package com.github.Evgenn91.f_typeAfterReturning;

import com.github.Evgenn91.f_typeAfterReturning.objects.Student;
import com.github.Evgenn91.f_typeAfterReturning.objects.University;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


/**
 * тип AfterReturning
 * выполняется только после нормального окончания метода с основной логикой,
 * но до присвоения результата этого метода какой либо переменной
 * (с его помощью возможно изменять возвращаемый результат)
 */
public class TestTypeAfterReturning {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        University university = context.getBean("university", University.class);
        university.addStudents();
        List<Student> students = university.getStudents(); /* результат работы этого метода мы можем изменить (см в папке aspects) */
        for(Student student: students){
            System.out.println(student);
        }

        context.close();
    }
}
