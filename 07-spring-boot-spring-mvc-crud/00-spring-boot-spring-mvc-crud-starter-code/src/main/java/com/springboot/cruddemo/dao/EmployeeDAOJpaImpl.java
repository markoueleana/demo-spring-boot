package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery= entityManager.createQuery("from Employee",Employee.class);
        List<Employee> employees= theQuery.getResultList();
        return employees;
    }
    @Override
    public Employee findById(int id ){
        Employee employee= entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee employee= entityManager.merge(theEmployee);
        return employee;
    }
    @Override
    public void delete(Employee theEmployee) {
        entityManager.remove(theEmployee);
    }
}
