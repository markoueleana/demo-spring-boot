package com.luv2code.thymeleafdemo.controller;

import com.luv2code.thymeleafdemo.student.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

@GetMapping("/showStudentForm")
    public String showForm(Model model){
        Student theStudent = new Student();
        model.addAttribute("student",theStudent);
        return "student-form";
    }
    @PostMapping("/processStudentForm")
    public String  processStudentForm(@ModelAttribute("student")Student theStudent){
    return "welcome-student-form";

    }
}
