package com.github.Evgenn91.g_type_Around.objects;

import org.springframework.stereotype.Component;

@Component
public class UniversityLibrary {


    public void getBook() {
        System.out.println("взял книгу из университета");
        System.out.println("---------------------------");
    }

    public String returnBook() {
        System.out.println("что то выполняется внутри метода returnBook");
        return "вернул книгу в университет";
    }

    public void getMagazine() {
        System.out.println("взял журнал из университета");
        System.out.println("---------------------------");
    }

    public String returnMagazine() {
        System.out.println("что то выполняется внутри метода returnMagazine");
        int a = 1/0;
        return "вернул журнал в университет";
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
