package springmvcstudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class SecondController {

    @RequestMapping("/normalMethod")
    public String normalHandler(@SessionAttribute("firstName") String firstName, Model model) {
        System.out.println("Inside normal handler firstName=" + firstName);
        model.addAttribute("firstName", "Dear " + firstName);
        return "index";
    }
}
