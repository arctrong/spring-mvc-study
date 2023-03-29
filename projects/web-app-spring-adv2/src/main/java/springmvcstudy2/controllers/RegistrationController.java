package springmvcstudy2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvcstudy2.model.CommunicationDto;
import springmvcstudy2.model.PhoneDto;
import springmvcstudy2.model.RegistrationDto;
import springmvcstudy2.propertyeditor.NamePropertyEditor;
import springmvcstudy2.validators.EmailValidator;
import springmvcstudy2.validators.UserNameValidator;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private EmailValidator emailValidator;

    @RequestMapping("/register")
    public String showRegistrationPage(@ModelAttribute("userReg") RegistrationDto userReg) {

        CommunicationDto communicationDto = new CommunicationDto();
        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setCountryCode("000");
        phoneDto.setUserNumber("0000000000");
        communicationDto.setPhone(phoneDto);
        userReg.setCommunicationDto(communicationDto);

        return "registration-page";
    }

    @RequestMapping("/registration-success")
    public String processUserRegistration(@Valid @ModelAttribute("userReg") RegistrationDto userReg,
                                          BindingResult result) {

        emailValidator.validate(userReg, result);

        if (result.hasErrors()) {
            return "registration-page";
        }
        return "registration-success";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        System.out.println("inside @InitBinder method");
//        dataBinder.setDisallowedFields("name");
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, "name", trimmerEditor);
        dataBinder.registerCustomEditor(String.class, "name", new NamePropertyEditor());
        dataBinder.addValidators(new UserNameValidator());
//        dataBinder.addValidators(new EmailValidator());
    }
}
