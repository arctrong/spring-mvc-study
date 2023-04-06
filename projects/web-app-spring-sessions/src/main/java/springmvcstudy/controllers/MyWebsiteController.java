package springmvcstudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import springmvcstudy.model.WebsiteInfoDto;

import java.util.concurrent.atomic.AtomicInteger;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

@Controller
@ControllerAdvice(assignableTypes = MyTestController.class)
@SessionAttributes("websiteInfo")
public class MyWebsiteController {

    private static AtomicInteger COUNT = new AtomicInteger(0);

    @ModelAttribute("websiteInfo")
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
        WebsiteInfoDto websiteInfo = (WebsiteInfoDto) model.getAttribute("websiteInfo");
        System.out.println("websiteInfo=" + reflectionToString(websiteInfo, JSON_STYLE));
        return "info";
    }

    @RequestMapping("/companyInfo")
    public String showCompanyInfo(@ModelAttribute("websiteInfo") WebsiteInfoDto websiteInfo) {
        System.out.println("Inside showCompanyInfo() method");
        System.out.println("websiteInfo=" + reflectionToString(websiteInfo, JSON_STYLE));
        websiteInfo.setWebsiteCategory(websiteInfo.getWebsiteCategory() + COUNT.incrementAndGet());
        return "info";
    }

    @RequestMapping("/divByZero")
    public String divideByZero() {
        int quotient = 57 / 0;
        return "info";
    }
}
