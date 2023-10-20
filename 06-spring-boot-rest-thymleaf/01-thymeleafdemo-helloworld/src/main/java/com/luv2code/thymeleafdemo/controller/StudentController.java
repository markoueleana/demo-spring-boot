package com.luv2code.thymeleafdemo.controller;

import com.luv2code.thymeleafdemo.student.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
@Value("${countries}")
private List<String> countries;
@GetMapping("/showStudentForm")
    public String showForm(Model model){
        Student theStudent = new Student();
        model.addAttribute("student",theStudent);
    model.addAttribute("countries",countries);
        return "student-form";
    }
    @PostMapping("/processStudentForm")
    public String  processStudentForm(@ModelAttribute("student")Student theStudent){
    return "welcome-student-form";

    }
}
