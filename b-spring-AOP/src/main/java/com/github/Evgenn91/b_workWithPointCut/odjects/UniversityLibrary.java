package com.github.Evgenn91.b_workWithPointCut.odjects;

import org.springframework.stereotype.Component;

@Component
public class UniversityLibrary extends AbstractLibrary{

    @Override
    public void getBook() {
        System.out.println("взял книгу из университета");
    }

    public void getBook(String str) {
        System.out.println("взял книгу c названием: " + str);
    }

    public void getBook(Book book) {
        System.out.println("взял книгу c названием: " + book.getName());
    }

    public String returnBook() {
        System.out.println("возвращаем String");
        return "возвращаем String";
    }
}
