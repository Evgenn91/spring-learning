package com.github.Evgenn91.a_typeBefore;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.github.Evgenn91.a_typeBefore")
//добавление этой аннотации позволяет нам использовать Spring AOP Proxy
@EnableAspectJAutoProxy
public class MyConfig {
}
