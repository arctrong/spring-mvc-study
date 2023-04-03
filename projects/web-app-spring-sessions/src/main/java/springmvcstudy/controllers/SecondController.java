package springmvcstudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class SecondController {

    @RequestMapping("/normalMethod")
    public String normalHandler(HttpSession session, Model model) {
        String address = (String) session.getAttribute("address");
        model.addAttribute("address", address + " - Normal");
        return "index";
    }
}
