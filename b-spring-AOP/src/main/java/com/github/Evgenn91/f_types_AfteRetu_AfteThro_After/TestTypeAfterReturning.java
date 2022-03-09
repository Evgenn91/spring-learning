package com.github.Evgenn91.f_types_AfteRetu_AfteThro_After;

import com.github.Evgenn91.f_types_AfteRetu_AfteThro_After.objects.Student;
import com.github.Evgenn91.f_types_AfteRetu_AfteThro_After.objects.University;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


/**
 * тип AfterReturning
 * выполняется только после нормального окончания метода с основной логикой,
 * но до присвоения результата этого метода какой либо переменной
 * (с его помощью возможно изменять возвращаемый результат)
 */

/**
 * тип AfterThrowing
 * выполняется после окончания работы метода,
 * если в нем было выбрашено исключение
 */

/**
 * тип After
 * выполняется после окончания метода с основной логикой,
 * вне зависимости от того, завершается ли метод нормально
 * или выбрасывает исключение
 *
 * с помощью него невозможно:
 * 1) получить доступ к исключению, которое выбросилось из метода с основной логикой;
 * 2) получить доступ к возвращаемому методом результату
 */
public class TestTypeAfterReturning {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        University university = context.getBean("university", University.class);
        university.addStudents();
        List<Student> students = university.getStudents(); /* результат работы этого метода мы можем изменить (см в папке aspects) */
        for(Student student: students){
            System.out.println(student);
        }

        try {
            university.getStr();
        } catch (Exception e){
            System.out.println("ошибка!");
        }


        context.close();
    }
}
