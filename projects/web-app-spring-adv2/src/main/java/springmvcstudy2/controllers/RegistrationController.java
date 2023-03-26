package springmvcstudy2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvcstudy2.model.RegistrationDto;
import springmvcstudy2.model.UserInfoDto;

@Controller
public class RegistrationController {

    @RequestMapping("/register")
    public String showRegistrationPage(@ModelAttribute("userReg") RegistrationDto userReg) {
        return "registration-page";
    }

    @RequestMapping("/registration-success")
    public String processUserRegistration(@ModelAttribute("userReg") RegistrationDto userReg) {
        return "registration-success";
    }
}
