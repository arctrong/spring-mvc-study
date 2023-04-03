package springmvcstudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes({"firstName", "lastName"})
public class FirstController {

    @RequestMapping("/first")
    public String firstHandler(Model model, HttpServletRequest request) {
        model.addAttribute("firstName", "Jan");
        model.addAttribute("lastName", "Hus");
        HttpSession session = request.getSession();
        session.setAttribute("address", "Prague, Czechia");
        return "index";
    }

    @RequestMapping("/second")
    public String secondHandler(SessionStatus status) {
        status.setComplete();
        return "index";
    }

    @RequestMapping("/third")
    public String thirdHandler(HttpSession session, Model model) {
        String address = (String) session.getAttribute("address");
        model.addAttribute("address", address + " - GREAT!");
        return "index";
    }
}
