package com.github.Evgenn91.e_ConfigurWithoutAnnotats_CompScan_Compon_Autow_Qualif;

import com.github.Evgenn91.e_ConfigurWithoutAnnotats_CompScan_Compon_Autow_Qualif.Objects.Cat;
import com.github.Evgenn91.e_ConfigurWithoutAnnotats_CompScan_Compon_Autow_Qualif.Objects.House;
import com.github.Evgenn91.e_ConfigurWithoutAnnotats_CompScan_Compon_Autow_Qualif.Objects.Person;
import com.github.Evgenn91.e_ConfigurWithoutAnnotats_CompScan_Compon_Autow_Qualif.Objects.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;


@Configuration/* означает, что данный класс является конфигурацией */
@PropertySource("classpath:c_myApp.properties")/* эту аннотацию мы прописали, чтобы здесь(где мы будем сканировать) можно было использовать значения из файлов в папке resourses, а именно из файла c_myApp.properties-->*/
public class MyConfig {

    @Bean
    @Scope("singleton")
    public Pet catBean(){
        return new Cat();
    }

    @Bean
    public House houseBean(){
        return new House();
    }

    @Bean
    public Person personBean(){
        Person person = new Person(catBean());
        person.setHouse(houseBean());
        return person;
    }



}
