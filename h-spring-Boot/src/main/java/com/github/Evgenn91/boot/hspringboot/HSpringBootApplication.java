package com.github.Evgenn91.boot.hspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Аннотация @SpringBootApplication заменяет такие аннотации как : @Configuration, @EnableAutoConfiguration, @ComponentScan
 */
@SpringBootApplication
public class HSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HSpringBootApplication.class, args);
    }

}
