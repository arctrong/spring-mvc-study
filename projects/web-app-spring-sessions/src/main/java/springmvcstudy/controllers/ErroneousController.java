package springmvcstudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvcstudy.model.WebsiteInfoDto;

@Controller
public class ErroneousController {

    WebsiteInfoDto websiteInfo; // intentionally not initialized

    @RequestMapping("/errorInfo")
    public String showWebsiteInfo() {
        System.out.println(websiteInfo.getWebsiteName());
        System.out.println(websiteInfo.getWebsiteCategory());
        return "info";
    }

    @ExceptionHandler(value = NullPointerException.class)
    public String showErrorPage() {
        return "nullPointerException";
    }
}
