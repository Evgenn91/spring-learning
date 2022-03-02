package com.github.Evgenn91.d_ConfigurationWithoutXml_and_annot_PropertySource.objects;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Pet {
    @Override
    public void say() { System.out.println("Gaw Gaw"); }
}
