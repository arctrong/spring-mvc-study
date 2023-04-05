package springmvcstudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvcstudy.model.WebsiteInfoDto;

@Controller
public class MyWebsiteController {

    @RequestMapping("/siteInfo")
    public String showWebsiteInfo(Model model) {
        WebsiteInfoDto websiteInfo = new WebsiteInfoDto();
        websiteInfo.setWebsiteName("need-for-spring.edu");
        websiteInfo.setWebsiteCategory("education");
        model.addAttribute("websiteInfo", websiteInfo);
        return "info";
    }
}
