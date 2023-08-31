package com.springboot.cruddemo.rest;
import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

     private EmployeeService employeeService;
    @Autowired
     public EmployeeRestController(EmployeeService theEmployeeService){
         employeeService=theEmployeeService;
     }
     @GetMapping("/employees")
    public List<Employee> findAll(){
         return  employeeService.findAll();
     }
     @GetMapping("/employee/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
         return  employeeService.findById(employeeId);
     }

     @PostMapping ("/employees")
    public Employee save(@RequestBody Employee theEmployee){
         theEmployee.setId(0);
         return  employeeService.save(theEmployee);
     }
     @PutMapping ("/employees")
    public Employee update(@RequestBody Employee employee){
         Employee theEmployee=  employeeService.save(employee);
         if (theEmployee==null){
             throw new RuntimeException("Employee id not found - " + employee.getId());
         }
         return theEmployee;
     }
     @DeleteMapping ("/employees/{employeeId}")
    public void delete(@PathVariable int employeeId){
        Employee theEmployee= employeeService.findById(employeeId);
        if (theEmployee==null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
          employeeService.delete(theEmployee);
    }
}
