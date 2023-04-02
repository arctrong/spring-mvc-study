package springmvcstudy2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvcstudy2.model.UserInfoValidatedDto;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ValidatedController {

    @RequestMapping("/validate")
    public String showHomePageSpring(@ModelAttribute("dto") UserInfoValidatedDto dto) {
        return "home-page-validated";
    }

    @RequestMapping("/validate-submit")
    public String showCalculatePageSpring(@Valid @ModelAttribute("dto") UserInfoValidatedDto dto,
                                          BindingResult result,
                                          HttpSession session) {
        System.out.println("showCalculatePageSpring called");
        if (result.hasErrors()) {
            System.out.println("VALIDATION: form has errors");
            result.getAllErrors().forEach(System.out::println);
            return "home-page-validated";
        }

        session.setAttribute("userName", dto.getName1());

        return "result-page-spring";
    }
}
