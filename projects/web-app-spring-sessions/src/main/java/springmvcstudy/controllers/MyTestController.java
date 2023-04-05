package springmvcstudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvcstudy.model.WebsiteInfoDto;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

@Controller
public class MyTestController {

    @RequestMapping("/test")
    public String showTestInfo(@ModelAttribute("websiteInfo") WebsiteInfoDto websiteInfo) {
        System.out.println("Inside showTestInfo() method");
        System.out.println("websiteInfo=" + reflectionToString(websiteInfo, JSON_STYLE));
        return "info";
    }
}
