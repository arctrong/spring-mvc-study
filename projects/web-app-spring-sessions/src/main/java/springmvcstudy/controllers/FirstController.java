package springmvcstudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"firstName", "lastName"})
public class FirstController {

    @RequestMapping("/first")
    public String firstHandler(Model model) {
        model.addAttribute("firstName", "Jan");
        model.addAttribute("lastName", "Hus");
        return "index";
    }

    @RequestMapping("/second")
    public String secondHandler(SessionStatus status) {
        status.setComplete();
        return "index";
    }

    @RequestMapping("/third")
    public String thirdHandler() {
        return "index";
    }
}
