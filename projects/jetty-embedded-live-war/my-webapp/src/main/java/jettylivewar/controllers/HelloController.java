package jettylivewar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello-jsp")
    public String helloJsp() {
        return "hello-page";
    }

    @RequestMapping("/system-properties")
    public String systemProperties() {
        return "system-properties-page";
    }
}
