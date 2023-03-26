package springmvcstudy2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvcstudy2.model.UserInfoValidatedDto;

import javax.validation.Valid;

@Controller
public class ValidatedController {

    @RequestMapping("/validate")
    public String showHomePageSpring(@ModelAttribute("dto") UserInfoValidatedDto dto) {
        return "home-page-validated";
    }

    @RequestMapping("/validate-submit")
    public String showCalculatePageSpring(@Valid @ModelAttribute("dto") UserInfoValidatedDto dto,
                                          BindingResult result) {
        System.out.println("showCalculatePageSpring called");
        if (result.hasErrors()) {
            System.out.println("VALIDATION: form has errors");
            result.getAllErrors().forEach(System.out::println);
            return "home-page-validated";
        }
        return "result-page-spring";
    }
}
