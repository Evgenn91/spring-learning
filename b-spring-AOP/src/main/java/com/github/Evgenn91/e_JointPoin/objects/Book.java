package com.github.Evgenn91.e_JointPoin.objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("Преступление и наказание")
    private String name;
    @Value("Достоевский")
    private String author;

    public String getName(){
        return name;
    }

    public String getAuthor(){
        return author;
    }
}
