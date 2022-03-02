package com.github.Evgenn91.a_IoC_beanScope_methodsInitAndDestroy.objects;

/**
 * методы init и detroy, нужны, чтобы показать
 * реализацию springom вызова определенных методов в момент создания бина и в момент его смерти
 * реализация в xml файле
 */
public class Dog implements Pet{

    @Override
    public void say() {
        System.out.println("Gav Gav");
    }

    public void myinit(){
        System.out.println("Class Dog: init method");
    }

    public void mydestroy(){
        System.out.println("Class Dog: destroy method");
    }
}
