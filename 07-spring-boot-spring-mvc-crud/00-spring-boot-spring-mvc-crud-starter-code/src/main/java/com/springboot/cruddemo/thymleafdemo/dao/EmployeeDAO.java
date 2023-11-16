package com.springboot.cruddemo.thymleafdemo.dao;

import com.springboot.cruddemo.thymleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    Employee findById(int id );
    Employee save(Employee employee);
    void delete(Employee employee);
}
