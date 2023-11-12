package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EntryCodeConstraintValidator implements ConstraintValidator<EntryCode, String> {
    private String codePrefix;

    @Override
    public void initialize(EntryCode constraintAnnotation) {
        codePrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            value = "";
        }
        return value.startsWith(codePrefix);
    }
}
