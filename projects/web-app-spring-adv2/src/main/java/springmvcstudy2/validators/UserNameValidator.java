package springmvcstudy2.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import springmvcstudy2.model.RegistrationDto;

public class UserNameValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return RegistrationDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
                "userName.empty", "User name should not be empty");
        String userName = ((RegistrationDto) target).getUserName();
        if (!userName.contains("_")) {
            errors.rejectValue("userName", "userName.invalidString",
                    "User name should contain an underscore (_)");
        }
    }
}
