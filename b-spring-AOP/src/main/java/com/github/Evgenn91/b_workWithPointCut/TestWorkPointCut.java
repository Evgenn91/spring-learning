package com.github.Evgenn91.b_workWithPointCut;


import com.github.Evgenn91.b_workWithPointCut.odjects.Book;
import com.github.Evgenn91.b_workWithPointCut.odjects.SchoolLibrary;
import com.github.Evgenn91.b_workWithPointCut.odjects.UniversityLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * разные выражения poin cut-ов
 */

public class TestWorkPointCut {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        schoolLibrary.getBook();

        System.out.println("-----------------");

        UniversityLibrary univerLibrary = context.getBean("universityLibrary", UniversityLibrary.class);

        univerLibrary.getBook();

        univerLibrary.getBook("Война и мир");

        Book book = context.getBean("book",Book.class);
        univerLibrary.getBook(book);

        univerLibrary.returnBook();

        context.close();
    }
}
