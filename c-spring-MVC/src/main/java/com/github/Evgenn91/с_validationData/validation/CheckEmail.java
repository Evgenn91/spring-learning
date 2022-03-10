package com.github.Evgenn91.с_validationData.validation;

import com.github.Evgenn91.с_validationData.controller.CheckEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)/*говорим к какому типу применяется аннотация (в данном случае к полю)*/
@Retention(RetentionPolicy.RUNTIME)/* говорим что аннотация созраняетмя до выполнения кода*/
@Constraint(validatedBy = CheckEmailValidator.class) /* именно этот класс будет обрабатывать эту аннотацию */
public @interface CheckEmail {
    public String value() default "xyz.com";
    public String message() default "имейл должен заканчиваться на xyz.com";
    public Class<?>[] groups() default {}; /* это дефолтное значение, его нужно вставлять в аннотацию, чтобы все работало норм */
    public Class<? extends Payload> [] payload() default {}; /* это дефолтное значение, его нужно вставлять в аннотацию, чтобы все работало норм */
}
