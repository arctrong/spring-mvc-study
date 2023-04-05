package springmvcstudy.controllers;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvcstudy.model.WebsiteInfoDto;

import static org.apache.commons.lang3.builder.ToStringBuilder.*;
import static org.apache.commons.lang3.builder.ToStringStyle.*;

@Controller
public class MyWebsiteController {

    @ModelAttribute
    private WebsiteInfoDto getWebsiteInfo() {
        System.out.println("Inside getWebsiteInfo() method");
        WebsiteInfoDto websiteInfo = new WebsiteInfoDto();
        websiteInfo.setWebsiteName("need-for-spring.edu");
        websiteInfo.setWebsiteCategory("education");
        return websiteInfo;
    }

    @RequestMapping("/siteInfo")
    public String showWebsiteInfo(Model model) {
        System.out.println("Inside showWebsiteInfo() method");
        WebsiteInfoDto websiteInfo = (WebsiteInfoDto) model.getAttribute("websiteInfoDto");
        System.out.println("websiteInfo=" + reflectionToString(websiteInfo, JSON_STYLE));
        return "info";
    }

    @RequestMapping("/companyInfo")
    public String showCompanyInfo() {
        System.out.println("Inside showCompanyInfo() method");
        return "info";
    }
}