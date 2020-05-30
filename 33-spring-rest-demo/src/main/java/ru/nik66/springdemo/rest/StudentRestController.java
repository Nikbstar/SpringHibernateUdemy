package ru.nik66.springdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nik66.springdemo.entity.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> result = new ArrayList<>();
        result.add(new Student("Poornima", "Patel"));
        result.add(new Student("Mario", "Rosi"));
        result.add(new Student("Mary", "Smith"));
        return result;
    }

}
