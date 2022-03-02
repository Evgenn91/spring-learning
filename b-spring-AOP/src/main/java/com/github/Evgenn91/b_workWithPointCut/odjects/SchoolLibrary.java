package com.github.Evgenn91.b_workWithPointCut.odjects;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstractLibrary {
    @Override
    public void getBook() {
        System.out.println("взял книгу из школы");
    }
}
