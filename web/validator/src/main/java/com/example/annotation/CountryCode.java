package com.example.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.example.validator.CountryCodeValidator;

@Documented
@Constraint(validatedBy = CountryCodeValidator.class)
@Target({ METHOD, FIELD, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface CountryCode {

    String message() default "Invalid CountryCode";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean notEmpty() default false;
}
