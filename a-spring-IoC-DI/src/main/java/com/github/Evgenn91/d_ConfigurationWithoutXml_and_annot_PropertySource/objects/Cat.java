package com.github.Evgenn91.d_ConfigurationWithoutXml_and_annot_PropertySource.objects;

import org.springframework.stereotype.Component;


@Component("catBean")
public class Cat implements Pet {
    @Override
    public void say() {
        System.out.println("Meow Meow");
    }
}
