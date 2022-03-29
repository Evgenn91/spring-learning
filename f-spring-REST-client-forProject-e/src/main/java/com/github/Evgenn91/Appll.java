package com.github.Evgenn91;


import com.github.Evgenn91.configuration.MyConfig;
import com.github.Evgenn91.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Appll
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
        List<Employee> all = communication.showAllEmployee();

    }
}
