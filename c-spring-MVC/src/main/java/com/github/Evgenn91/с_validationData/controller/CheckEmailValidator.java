package com.github.Evgenn91.с_validationData.controller;

import com.github.Evgenn91.с_validationData.validation.CheckEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckEmailValidator implements ConstraintValidator<CheckEmail, String> /* CheckEmail - название аннотации, String - тип данных, к которому она будет применена */ {
    private String endOfEmail; /* конец имейла, который должен быть */
    @Override
    public void initialize(CheckEmail constraintAnnotation) {
        endOfEmail = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) /*s - это то, что мы должны напимать в email*/{
        return s.endsWith(endOfEmail);
    }
}
