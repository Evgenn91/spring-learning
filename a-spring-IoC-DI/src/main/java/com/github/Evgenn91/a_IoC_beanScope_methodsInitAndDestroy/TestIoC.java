package com.github.Evgenn91.a_IoC_beanScope_methodsInitAndDestroy;

import com.github.Evgenn91.a_IoC_beanScope_methodsInitAndDestroy.objects.Pet;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoC {
    public static void main( String[] args )
    {
        //Создаем SpringContainer(место, где создаются и хранятся наши Beans)
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("a_applicationContextIoC.xml");
        /*можно сделать чтобы из нескольких файлов брались бины(перечисляем их через запятую, пример:("файл1.xml","файл2.xml","файл3.xml"))*/

        //берем из SpringContainer Bean под названием myPet(это имя мы определили в a_applicationContextIoC.xml) и типом класса Pet.class(лучше указывать родителя)
        Pet dog = context.getBean("myPet", Pet.class); //myPet это название в файле: "a_applicationContextIoC.xml"

        dog.say();

        context.close(); //обязательно в конце работы нужно закрывать контекст
    }
}
