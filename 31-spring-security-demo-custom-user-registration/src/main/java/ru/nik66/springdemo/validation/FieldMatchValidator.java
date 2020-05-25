package ru.nik66.springdemo.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String firstFieldName;
    private String secondFieldName;
    private String message;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        firstFieldName = constraintAnnotation.second();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        boolean result = true;
        Object firstObj = new BeanWrapperImpl(value).getPropertyValue(firstFieldName);
        Object secondObj = new BeanWrapperImpl(value).getPropertyValue(secondFieldName);
        result = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        if (!result) {
            context.buildConstraintViolationWithTemplate(message).addPropertyNode(firstFieldName).addConstraintViolation().disableDefaultConstraintViolation();
        }
        return result;
    }

}
