package com.github.Evgenn91.d_orderOfExcecutionAspects.objects;

import org.springframework.stereotype.Component;

@Component
public class UniversityLibrary {


    public void getBook() {
        System.out.println("взял книгу из университета");
    }

    public void returnBook() {System.out.println("вернул книгу в университет");}

    public void getMagazine() {
        System.out.println("взял журнал из университета");
    }

    public void returnMagazine() {
        System.out.println("вернул журнал в университет");
    }

    public void addBook() {
        System.out.println("добавляем книгу в университет");
    }

    public void addMagazine() {
        System.out.println("добавляем журнал в университет");
    }


}
