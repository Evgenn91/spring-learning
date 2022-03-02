package com.github.Evgenn91.a_IoC_beanScope_methodsInitAndDestroy.objects;

public class Cat implements Pet{
    @Override
    public void say() {
        System.out.println("Meow Meow");
    }
}
