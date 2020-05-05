package ru.nik66.springdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

   private String coursePrefix;

   @Override
   public void initialize(CourseCode constraint) {
      this.coursePrefix = constraint.value();
   }

   @Override
   public boolean isValid(String code, ConstraintValidatorContext context) {
      return code == null || code.startsWith(this.coursePrefix);
   }

}
