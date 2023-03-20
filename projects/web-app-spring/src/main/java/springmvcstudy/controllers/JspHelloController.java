package springmvcstudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class JspHelloController {

    @RequestMapping("/hello")
    public String getJspHello() {
        return "/view/jspHello.jsp";
    }
}
