package springmvcstudy2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import springmvcstudy2.model.SendEmailDto;
import springmvcstudy2.model.UserInfoDto;
import springmvcstudy2.model.UserInfoValidatedDto;
import springmvcstudy2.service.MyAppEmailService;

@Controller
public class EmailController {

    @Autowired
    private MyAppEmailService emailService;

    @RequestMapping("/sendEmail")
    public String sendEmail(Model model) {
        model.addAttribute("sendEmailDto", new SendEmailDto());
        return "send-email-page";
    }

    @RequestMapping("/process-email")
    public String processEmail(
            @SessionAttribute("userInfoDto") UserInfoValidatedDto userInfoDto,
            @ModelAttribute SendEmailDto sendEmailDto) {

        emailService.sendEmail(userInfoDto.getName1(), sendEmailDto.getUserEmail(), "GOOD");

        return "process-email-page";
    }
}
