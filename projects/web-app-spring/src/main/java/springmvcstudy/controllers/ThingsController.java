package springmvcstudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/things")
@ResponseBody
public class ThingsController {

    @RequestMapping
    public String getThingList() {
        return "pen, pencil, book";
    }

    @RequestMapping("/pen")
    public String getPen() {
        return "Here is your pen!";
    }

    @RequestMapping("/pencil")
    public String getPencil() {
        return "Here is your pencil!";
    }

    @RequestMapping("/book")
    public String getBook() {
        return "Here is your book!";
    }
}
