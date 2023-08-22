package com.springboot.cruddemo.service;

import com.springboot.cruddemo.dao.EmployeeDAO;
import com.springboot.cruddemo.dao.EmployeeDAOJpaImpl;
import com.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO=theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
