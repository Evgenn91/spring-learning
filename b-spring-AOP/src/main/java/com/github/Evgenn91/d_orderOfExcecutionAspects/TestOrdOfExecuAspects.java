package com.github.Evgenn91.d_orderOfExcecutionAspects;


import com.github.Evgenn91.d_orderOfExcecutionAspects.objects.UniversityLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Порядок выполнения аспектов
 * Сделаем, чтобы сначала происходило логирование а потом проверка
 */
public class TestOrdOfExecuAspects {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniversityLibrary universityLibrary = context.getBean("universityLibrary", UniversityLibrary.class);

        System.out.println("метод returnBook: ");
        universityLibrary.returnBook();
        System.out.println("------------------");
        System.out.println("метод getBook: ");
        universityLibrary.getBook();
        System.out.println("------------------");
        System.out.println("метод returnMagazine: ");
        universityLibrary.returnMagazine();
        System.out.println("------------------");
        System.out.println("метод getMagazine: ");
        universityLibrary.getMagazine();
        System.out.println("------------------");


        context.close();
    }
}
