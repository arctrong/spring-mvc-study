package springmvcstudy2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvcstudy2.model.SendEmailDto;

import javax.servlet.http.HttpSession;

@Controller
public class EmailController {

    @RequestMapping("/sendEmail")
    public String sendEmail(Model model) {
        model.addAttribute("sendEmailDto", new SendEmailDto());
        return "send-email-page";
    }

    @RequestMapping("/process-email")
    public String processEmail(@ModelAttribute SendEmailDto sendEmailDto,
                               HttpSession session, Model model) {
        model.addAttribute("userName", "dear " + session.getAttribute("userName"));
        return "process-email-page";
    }
}
