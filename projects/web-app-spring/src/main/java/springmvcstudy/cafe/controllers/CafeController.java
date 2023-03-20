package springmvcstudy.cafe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cafe")
public class CafeController {

    @RequestMapping
    public String showWelcomePage() {
        return "welcome-page";
    }

    @RequestMapping("/processOrder")
    public String processOrder(HttpServletRequest request, Model model) {
        String itemName = request.getParameter("itemName");
        model.addAttribute("itemName", itemName);
        return "process-order";
    }
}
