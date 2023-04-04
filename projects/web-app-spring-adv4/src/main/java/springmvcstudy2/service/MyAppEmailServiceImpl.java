package springmvcstudy2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MyAppEmailServiceImpl implements MyAppEmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String userName, String userEmail, String result) {
        SimpleMailMessage newEmail = new SimpleMailMessage();
        newEmail.setFrom("noreply@myapp.com");
        newEmail.setTo(userEmail);
        newEmail.setSubject("Test massage (may be deleted any time)");
        newEmail.setText("Hi " + userName + ", your result is: " + result);

        mailSender.send(newEmail);
    }
}
