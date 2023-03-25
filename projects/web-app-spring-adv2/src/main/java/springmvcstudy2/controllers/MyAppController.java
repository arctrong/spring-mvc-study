package springmvcstudy2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyAppController {

    @RequestMapping("/")
    public String showHomePage() {
        return "home-page";
    }

    @RequestMapping("/calculate-page")
    public String showCalculatePage(@RequestParam("name1") String firstName,
                                    @RequestParam String name2,
                                    Model model) {
        model.addAttribute("firstName", firstName);
        model.addAttribute("secondName", name2);

        return "result-page";
    }

}
