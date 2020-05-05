package ru.nik66.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.nik66.springdemo.model.Student;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
//        model.addAttribute("countriesList", getCountriesList());
        model.addAttribute("countriesList", countryOptions);
        model.addAttribute("favoriteLanguageList", getFavoriteLanguageList());
        return "student-form";
    }

    private Map<String, String> getFavoriteLanguageList() {
        Map<String, String> result = new LinkedHashMap<>();
        result.put("Java", "Java");
        result.put("C#", "C#");
        result.put("PHP", "PHP");
        result.put("Ruby", "Ruby");
        result.put("Python", "Python");
        result.put("Delphi", "Delphi");
        return result;
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {
        System.out.println("StudentController.processForm: Student name - " + student.toString());
        return "student-confirmation";
    }

//    private Map<String, String> getCountriesList() {
//        Map<String, String> result = new LinkedHashMap<>();
//        result.put("BR", "Brazil");
//        result.put("FR", "France");
//        result.put("DE", "Germany");
//        result.put("IN", "India");
//        result.put("RU", "Russia");
//        return result;
//    }

}
