package com.github.Evgenn91.c_ConfWithAnnot_Compo_Autow_Qualif_Valu_Scop_PostC_PreDest.Objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Person {
    private Pet pet;
//  @Autowired /* это внедрение поля(DI)*/ - не используем, т.к. написали над сеттером, хотя это одно и тоже как я понял
    private House house;
    @Value("Nikulin")/* заполнение поля значением, а не другим бином (так обычно не заполняют - тоесть прямо в классе прописывая значение)*/
    private String surname;
//    @Value("${person.age}") /* заполнение поля значением, а не другим бином (правильный вариант, т.к. само значение лежит в файле c_myApp.properties; что там лежит, это указано в xml файле)*/
    private int age;

    /**
     * @Qualifier можно написать и над переменной в классе, только немного по другому напишем:
     *
     * @Autowired - если бы не вводили pet в конструкторе, а с помощью сеттера, то написали бы над полем, как сдесь
     * @Qualifier("dog")
     * private Pet pet;
     */
    @Autowired /* это внедрение зависимости в конструкторе(DI)*/
    public Person(@Qualifier("dog") Pet pet) { /* @Qualifier c помощью него определили какой именно потомок Pet будет внедрен(Dog или Cat)*/
         this.pet = pet;
    }

    public void callYourPet(){
        System.out.println("Hello my Pet");
        pet.say();
    }

    @PostConstruct/* String вызовет этот метод, когда будет создавать бин Person */
    public void myinit(){
        System.out.println("Class Dog: init method");
    }

    @PreDestroy/* этот метод вызовет String, когда будет уничтожать бин Person */
    public void mydestroy(){
        System.out.println("Class Dog: destroy method");
    }

    public House getHouse() {
        return house;
    }

    @Autowired /* это внедрение зависимости в сеттере(DI)*/
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
