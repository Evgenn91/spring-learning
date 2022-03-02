package com.github.Evgenn91.b_DI;

import com.github.Evgenn91.a_IoC_beanScope_methodsInitAndDestroy.objects.Pet;
import com.github.Evgenn91.b_DI.objects.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {
    public static void main(String[] args) {
        //можно сделать, как мы делали в IoC
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("b_applicationContextDI.xml");
        /*до DI*/
        Pet pet = context.getBean("myPet", Pet.class);
//        и сдесь мы жестко привязываем домашнее животное к person(сильная зависимость)
//        вместо этого мы можем сделать это в xml файле
//        Person person = new Person(pet);
//        House house = new House();
//        person.setHouse(house);
//        person.setSurname("Nikulin");
//        person.setAge(30);
        /*c DI*/
        Person person = context.getBean("myPerson", Person.class);
        person.callYourPet();
        System.out.println("house - "+person.getHouse());
        System.out.println("age - "+person.getAge());

        context.close();
    }
}
