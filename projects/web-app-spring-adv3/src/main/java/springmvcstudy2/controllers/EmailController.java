package springmvcstudy2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvcstudy2.model.SendEmailDto;

import java.util.Map;

@Controller
public class EmailController {

    @RequestMapping("/sendEmail")
    public String sendEmail(@CookieValue("myApp.userName") String userName, Model model) {
        model.addAttribute("sendEmailDto", new SendEmailDto());
        model.addAttribute("userName", userName);
        return "send-email-page";
    }

    @RequestMapping("/process-email")
    public String processEmail(@ModelAttribute SendEmailDto sendEmailDto) {
        return "process-email-page";
    }
}
