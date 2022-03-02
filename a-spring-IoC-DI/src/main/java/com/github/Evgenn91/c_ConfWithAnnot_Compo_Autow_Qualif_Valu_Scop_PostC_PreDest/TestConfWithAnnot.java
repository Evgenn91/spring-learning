package com.github.Evgenn91.c_ConfWithAnnot_Compo_Autow_Qualif_Valu_Scop_PostC_PreDest;

import com.github.Evgenn91.c_ConfWithAnnot_Compo_Autow_Qualif_Valu_Scop_PostC_PreDest.Objects.Cat;
import com.github.Evgenn91.c_ConfWithAnnot_Compo_Autow_Qualif_Valu_Scop_PostC_PreDest.Objects.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConfWithAnnot {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("c_applicationContextConfAnnot.xml");

        Cat myCat = applicationContext.getBean("catBean", Cat.class); /*если нет названия у бина то spring поймет, что cat - это название класса,
        он заменит первую букву на заглавную: Cat myCat = applicationContext.getBean("cat", Cat.class); */
        myCat.say();

        Person person = applicationContext.getBean("person",Person.class);
        person.callYourPet();
        System.out.println("house - "+person.getHouse());
        System.out.println("age - "+person.getAge());
        
        applicationContext.close();
    }
}
