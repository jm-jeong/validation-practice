package com.example.validationpractice.validator;

import com.example.validationpractice.annotation.YearMonth;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {
    private String pattern;
    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        var reValue = value + "01";
        var rePattern = pattern + "dd";

        try {

            LocalDate date = LocalDate.parse(reValue, DateTimeFormatter.ofPattern(rePattern));
            System.out.println("date = " + date);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
