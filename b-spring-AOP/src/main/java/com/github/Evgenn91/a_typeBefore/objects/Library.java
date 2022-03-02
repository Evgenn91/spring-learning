package com.github.Evgenn91.a_typeBefore.objects;

import org.springframework.stereotype.Component;

@Component("LibraryBean")
public class Library {

    public void getBook(){
        System.out.println("взял книгу");
    }
}
