package com.github.Evgenn91.b_DI.Objects;

import com.github.Evgenn91.a_IoC_beanScope_methodsInitAndDestroy.Objects.Pet;

public class Person {
    private Pet pet;
    private House house;
    private String surname;
    private int age;

    public Person(Pet pet) {
        this.pet = pet;
    }

    public void callYourPet(){
        System.out.println("Hello my Pet");
        pet.say();
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
