package ru.renicheronte.springMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/example")
public class ExampleController {
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        model.addAttribute("helloMessage", "Hello " + name + " " + surname);

        return "example/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname,
                              Model model) {
        model.addAttribute("goodbyeMessage", "Goodbye " + name + " " + surname);
        return "example/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", defaultValue = "5") int a,
                             @RequestParam(value = "b", defaultValue = "5") int b,
                             @RequestParam(value = "action", defaultValue = "addition") String action,
                             Model model) {
        double result = switch (action) {
            case "addition" -> a + b;
            case "subtract" -> a - b;
            case "multiplication" -> a * b;
            case "division" -> a / (double) b;
            default -> 0;
        };
        model.addAttribute("result", result);
        return "example/calculator";
    }
}
