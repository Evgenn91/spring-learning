package com.github.Evgenn91.d_ConfigurationWithoutXml_and_annot_PropertySource.objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Person {
    private Pet pet;
    private House house;
    @Value("Nikulin")
    private String surname;
    @Value("${person.age}")
    private int age;

    @Autowired
    public Person(@Qualifier("dog") Pet pet) { /* @Qualifier c помощью него определили какой именно потомок Pet будет внедрен(Dog или Cat)*/
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

    @Autowired
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
