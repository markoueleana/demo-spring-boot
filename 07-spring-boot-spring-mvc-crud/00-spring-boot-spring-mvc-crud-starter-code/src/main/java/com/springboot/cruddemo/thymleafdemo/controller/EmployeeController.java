package com.springboot.cruddemo.thymleafdemo.controller;

import com.springboot.cruddemo.thymleafdemo.entity.Employee;
import com.springboot.cruddemo.thymleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String addEmployee(Model theModel){
        Employee theEmployees =new Employee();
        theModel.addAttribute("employee",theEmployees);
        return "employees/add-employee";
    }
    @GetMapping("/showFromForUpdate")
    public String updateEmployee(@RequestParam("employeeId") int employeeId, Model theModel){
        Employee theEmployees =  employeeService.findById(employeeId);

        theModel.addAttribute("employee",theEmployees);
        return "employees/update-employee";
    }
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int employeeId, Model theModel){
        Employee theEmployees =  employeeService.findById(employeeId);
        employeeService.delete(theEmployees);
        return "redirect:/employees/list";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theNewEmployee){
        employeeService.save(theNewEmployee);
        return "employees/confirmation-employee";
    }
}
