package com.springboot.cruddemo.thymleafdemo.service;

import com.springboot.cruddemo.thymleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void delete(Employee employee);
}
