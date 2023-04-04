package springmvcstudy2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import springmvcstudy2.model.UserInfoValidatedDto;
import springmvcstudy2.service.MyAppCalculatorService;

import javax.validation.Valid;

@Controller
@SessionAttributes("userInfoDto")
public class ValidatedController {

    @Autowired
    private MyAppCalculatorService calculatorService;

    @RequestMapping("/validate")
    public String showHomePageSpring(Model model) {
        model.addAttribute("userInfoDto", new UserInfoValidatedDto());
        return "home-page-validated";
    }

    @RequestMapping("/validate-submit")
    public String showCalculatePageSpring(
            @Valid @ModelAttribute("userInfoDto") UserInfoValidatedDto userInfoDto,
            BindingResult result) {
        System.out.println("showCalculatePageSpring called");
        if (result.hasErrors()) {
            System.out.println("VALIDATION: form has errors");
            result.getAllErrors().forEach(System.out::println);
            return "home-page-validated";
        }

        String calculationResult =
                calculatorService.calculate(userInfoDto.getName1(), userInfoDto.getName2());
        userInfoDto.setCalculationResult(calculationResult);

        return "result-page-spring";
    }
}
