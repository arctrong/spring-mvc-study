package springmvcstudy2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springmvcstudy2.model.UserInfoDto;

@Controller
public class MyAppController {

    @RequestMapping("/")
    public String showHomePage() {
        return "home-page";
    }

    @RequestMapping("/calculate-page")
    public String showCalculatePage(@RequestParam("name1") String firstName,
                                    @RequestParam String name2,
                                    Model model) {
        model.addAttribute("firstName", firstName);
        model.addAttribute("secondName", name2);
        return "result-page";
    }

    @RequestMapping("/calculate-page-dto")
    public String showCalculatePageDto(UserInfoDto dto, Model model) {
        model.addAttribute("firstName", dto.getName1());
        model.addAttribute("secondName", dto.getName2());
        return "result-page";
    }

    @RequestMapping("/spring")
    public String showHomePageSpring(Model model) {
        UserInfoDto dto = new UserInfoDto();
        model.addAttribute("userInfo", dto);
        return "home-page-spring";
    }

    @RequestMapping("/calculate-page-springs")
    public String showCalculatePageSpring(UserInfoDto dto, Model model) {
        model.addAttribute("dto", dto);
        return "result-page-spring";
    }

}
