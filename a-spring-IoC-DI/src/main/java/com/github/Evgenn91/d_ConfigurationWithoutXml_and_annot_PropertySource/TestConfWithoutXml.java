package com.github.Evgenn91.d_ConfigurationWithoutXml_and_annot_PropertySource;


import com.github.Evgenn91.d_ConfigurationWithoutXml_and_annot_PropertySource.Objects.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfWithoutXml {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Person person = context.getBean("person", Person.class);

        person.callYourPet();
        System.out.println("house - "+person.getHouse());
        System.out.println("age - "+person.getAge());

        context.close();
    }
}
