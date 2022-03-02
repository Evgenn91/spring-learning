package com.github.Evgenn91.e_ConfigurWithoutAnnotats_CompScan_Compon_Autow_Qualif.Objects;


import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Person {
    private Pet pet;
    private House house;
    @Value("Nikulin")
    private String surname;
    @Value("${person.age}")
    private int age;

    public Person(Pet pet) { /* @Qualifier c помощью него определили какой именно потомок Pet будет внедрен(Dog или Cat)*/
         this.pet = pet;
    }

    public void callYourPet(){
        System.out.println("Hello my Pet");
        pet.say();
    }

    @PostConstruct
    public void myinit(){
        System.out.println("Class Person: init method");
    }

    @PreDestroy
    public void mydestroy(){
        System.out.println("Class Person: destroy method");
    }

    public House getHouse() {
        return house;
    }


    public void setHouse(House house) {
        this.house = house;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
