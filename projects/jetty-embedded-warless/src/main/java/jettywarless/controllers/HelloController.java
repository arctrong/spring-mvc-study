package jettywarless.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String simpleHello() {
        return "Hello from " + this.getClass().getSimpleName();
    }

    @RequestMapping("/hello-jsp")
    public String helloJsp() {
        return "hello-page";
    }

    @RequestMapping("/system-properties")
    public String systemProperties() {
        return "system-properties-page";
    }
}
