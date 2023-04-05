package springmvcstudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyWebsiteController {

    @RequestMapping("/info")
    public String showWebsiteInfo() {
        return "info";
    }
}
