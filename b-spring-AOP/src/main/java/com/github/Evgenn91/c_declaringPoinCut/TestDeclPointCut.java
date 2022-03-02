package com.github.Evgenn91.c_declaringPoinCut;

import com.github.Evgenn91.c_declaringPoinCut.odjects.UniversityLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



/**
 * Объявление и комбинирование PointCut-ов
 */
public class TestDeclPointCut {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniversityLibrary univerLibrary = context.getBean("universityLibrary", UniversityLibrary.class);

        System.out.println("метод getBook");
        univerLibrary.getBook();
        System.out.println("----------------------");
        System.out.println("метод getMagazine");
        univerLibrary.getMagazine();
        System.out.println("----------------------");
        System.out.println("метод returnBook");
        univerLibrary.returnBook();
        System.out.println("----------------------");
        System.out.println("метод returnMagazine");
        univerLibrary.returnMagazine();
        System.out.println("----------------------");


        context.close();
    }
}
