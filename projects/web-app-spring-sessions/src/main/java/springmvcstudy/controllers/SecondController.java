package springmvcstudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecondController {

    @RequestMapping("/normalMethod")
    public String normalHandler(Model model) {
        String firstName = (String) model.getAttribute("firstName");
        System.out.println("Inside normal handler firstName=" + firstName);
        return "index";
    }
}
