package springmvcstudy2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvcstudy2.model.UserInfoValidatedDto;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class ValidatedController {

    @RequestMapping("/validate")
    public String showHomePageSpring(@ModelAttribute("dto") UserInfoValidatedDto dto,
                                     HttpServletRequest request) {
        for (Cookie cookie : request.getCookies()) {
            if ("myApp.userName".equals(cookie.getName())) {
                dto.setName1(cookie.getValue());
            }
        }
        return "home-page-validated";
    }

    @RequestMapping("/validate-submit")
    public String showCalculatePageSpring(@Valid @ModelAttribute("dto") UserInfoValidatedDto dto,
                                          BindingResult result,
                                          HttpServletResponse response) {
        System.out.println("showCalculatePageSpring called");
        if (result.hasErrors()) {
            System.out.println("VALIDATION: form has errors");
            result.getAllErrors().forEach(System.out::println);
            return "home-page-validated";
        }

        Cookie cookie = new Cookie("myApp.userName", dto.getName1());
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);

        return "result-page-spring";
    }
}
