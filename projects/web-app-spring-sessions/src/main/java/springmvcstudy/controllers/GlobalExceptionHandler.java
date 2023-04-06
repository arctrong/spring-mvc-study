package springmvcstudy.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public String showErrorPage(Exception exception, Model model) {
        model.addAttribute("exception", exception.getClass().getSimpleName());
        return "exception";
    }
}
