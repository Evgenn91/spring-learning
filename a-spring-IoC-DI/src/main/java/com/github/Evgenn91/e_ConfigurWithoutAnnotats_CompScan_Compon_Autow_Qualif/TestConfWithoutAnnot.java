package com.github.Evgenn91.e_ConfigurWithoutAnnotats_CompScan_Compon_Autow_Qualif;


import com.github.Evgenn91.e_ConfigurWithoutAnnotats_CompScan_Compon_Autow_Qualif.Objects.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * отличие от пакета d(d_ConfigurationWithoutXml_and_annot_PropertySource)
 * что здесь мы будем описывать бины в конфиг файле (myConfig)
 * и поэтому аннотации
 * @ComponentScan
 * @Component
 * @Autowired
 * @Qualifier
 * нам не нужны!!!
 */
public class TestConfWithoutAnnot {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Person person = context.getBean("personBean", Person.class);

        person.callYourPet();
        System.out.println("house - "+person.getHouse());
        System.out.println("age - "+person.getAge());

        context.close();
    }
}
