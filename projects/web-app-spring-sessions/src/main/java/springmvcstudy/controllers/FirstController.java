package springmvcstudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {

    @RequestMapping("/first")
    public String firstHandler(Model model) {
        model.addAttribute("firstName", "Jan");
        model.addAttribute("lastName", "Hus");
        return "index";
    }

    @RequestMapping("/second")
    public String secondHandler(Model model) {
        String firstName = (String) model.getAttribute("firstName");
        System.out.println("firstName=" + firstName);
        return "index";
    }
}