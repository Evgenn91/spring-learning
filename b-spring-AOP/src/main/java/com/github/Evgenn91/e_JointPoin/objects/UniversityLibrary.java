package com.github.Evgenn91.e_JointPoin.objects;

import org.springframework.stereotype.Component;

@Component
public class UniversityLibrary {


    public void getBook() {
        System.out.println("взял книгу из университета");
        System.out.println("---------------------------");
    }

    public void returnBook() {
        System.out.println("вернул книгу в университет");
        System.out.println("---------------------------");
    }

    public void getMagazine() {
        System.out.println("взял журнал из университета");
        System.out.println("---------------------------");
    }

    public void returnMagazine() {
        System.out.println("вернул журнал в университет");
        System.out.println("---------------------------");
    }

    public void addBook(String str) {
        System.out.println("добавляем книгу в университет: "+str);
        System.out.println("---------------------------");
    }

    public void addMagazine() {
        System.out.println("добавляем журнал в университет");
        System.out.println("---------------------------");
    }


}
