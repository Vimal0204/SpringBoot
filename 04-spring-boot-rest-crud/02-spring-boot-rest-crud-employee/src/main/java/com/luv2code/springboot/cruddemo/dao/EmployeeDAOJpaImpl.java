package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
    //define field for entitymanager
    EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager thEntityManager){
        entityManager=thEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> thQuery=entityManager.createQuery("from Employee",Employee.class);
        //execute query and get result list
        List<Employee>employees=thQuery.getResultList();

        //return the list
        return employees;

    }

    @Override
    public Employee findById(int theId) {
        // get employee
        Employee theEmployee = entityManager.find(Employee.class,theId);
        // return the employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //save employee
        Employee dbEmployee = entityManager.merge(theEmployee);
        // return employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        // find the employee
        Employee theEmployee = entityManager.find(Employee.class,theId);
        // remove the employee
        entityManager.remove(theEmployee);
    }
}
