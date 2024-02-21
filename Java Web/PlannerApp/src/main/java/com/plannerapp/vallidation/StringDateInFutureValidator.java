package com.plannerapp.vallidation;

import com.plannerapp.model.annotation.StringDateInFuture;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class StringDateInFutureValidator implements ConstraintValidator<StringDateInFuture, String> {
    @Override
    public void initialize(StringDateInFuture constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value != null && !value.isBlank()) {
            LocalDate parse = LocalDate.parse(value);
            return parse.isAfter(LocalDate.now());
        }
        return false;
    }
}
