package springmvcstudy2.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import springmvcstudy2.model.RegistrationDto;

@Component
public class EmailValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return RegistrationDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDto.email", "email.empty");
        String email = ((RegistrationDto) target).getCommunicationDto().getEmail();
        if (!email.endsWith("@certain-domain.com")) {
            errors.rejectValue("communicationDto.email", "email.invalidDomain");
        }
    }
}
