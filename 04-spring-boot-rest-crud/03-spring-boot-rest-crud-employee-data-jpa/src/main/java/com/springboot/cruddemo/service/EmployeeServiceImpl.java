package com.springboot.cruddemo.service;

import com.springboot.cruddemo.dao.EmployeeRepository;
import com.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository=theEmployeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee findById(int id) {
        Employee theEmployee;
        Optional<Employee> result = employeeRepository.findById(id);
        if (result.isPresent()){
            theEmployee=result.get();
        }else throw  new RuntimeException("Employee Id not found: "+id);
        return theEmployee;
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Transactional
    @Override
    public void delete(Employee theEmployee) {
        employeeRepository.delete(theEmployee);
    }
}
