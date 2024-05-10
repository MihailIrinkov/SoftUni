package com.dictionaryapp.validation.anotation;

import com.dictionaryapp.validation.UniqueEmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueEmail {
    String message() default "Email is already used!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}