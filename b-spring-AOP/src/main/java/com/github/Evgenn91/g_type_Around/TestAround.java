package com.github.Evgenn91.g_type_Around;


import com.github.Evgenn91.g_type_Around.objects.UniversityLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * тип Around -
 * выполняется до и после метода с основной логикой
 * Самый многофункциональный, что можно:
 * 1) произвести какие-либо действия до работы target метода;
 * 2) произвести какие-либо действия после работы target матода;
 * 3) получить результат работы target метода/изменить его;
 * 4) предпринять какие-либо действия, если из target метода выбрасывается исключение;
 */


public class TestAround {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        UniversityLibrary universityLibrary = context.getBean("universityLibrary",UniversityLibrary.class);

        System.out.println("начинаем работу с методом returnBook в test");
        System.out.println(universityLibrary.returnBook());

        System.out.println("----------------");

        System.out.println("начинаем работу с методом returnMagazine в test");
        try{
            System.out.println(universityLibrary.returnMagazine());
        } catch (Exception e){
            System.out.println("произошла ошибка в методе returnMagazine");
        }

        context.close();

    }
}
