package com.springboot.cruddemo.thymleafdemo.controller;

import com.springboot.cruddemo.thymleafdemo.entity.Employee;
import com.springboot.cruddemo.thymleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    public EmployeeController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel){
        List<Employee> theEmployees = employeeService.findAll();
        theModel.addAttribute("employees",theEmployees);
        return "employees/list-employees";
    }
    @GetMapping("/showFromForAdd")
    public String addEmploye(Model theModel){
        Employee theEmployees =new Employee();
        theModel.addAttribute("employee",theEmployees);
        return "employees/add-employee";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theNewEmployee){
        employeeService.save(theNewEmployee);
        return "employees/confirmation-employee";
    }
}
