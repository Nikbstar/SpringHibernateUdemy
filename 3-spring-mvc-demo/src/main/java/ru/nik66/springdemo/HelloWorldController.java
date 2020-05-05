package ru.nik66.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        String studentName = request.getParameter("studentName");
        String resutl = "Yo! " + studentName.toUpperCase();
        model.addAttribute("message", resutl);
        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String letsShoutDudeNew(@RequestParam("studentName") String studentName, Model model) {
        String result = "Hello from v3! " + studentName.toUpperCase();
        model.addAttribute("message", result);
        return "helloworld";
    }

}
