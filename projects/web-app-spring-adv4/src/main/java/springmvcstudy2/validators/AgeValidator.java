package springmvcstudy2.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {

    private int lower;
    private int upper;

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext constraintValidatorContext) {
        return age != null && age >= this.lower && age <= this.upper;
    }

    @Override
    public void initialize(Age age) {
        this.lower = age.lower();
        this.upper = age.upper();
    }
}
