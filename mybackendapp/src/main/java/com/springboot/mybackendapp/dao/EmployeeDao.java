package com.springboot.mybackendapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.springboot.mybackendapp.entity.Employee;

@Repository
public class EmployeeDao {

	@Autowired
    private EntityManager entityManager;
 
	//constructor injection
    public EmployeeDao(EntityManager em) {
        this.entityManager = em;
    }
 
    public List<Employee> getEmployees() {
    	//current hibernate session
        Session session = this.entityManager.unwrap(Session.class);
        
        List<Employee> employees = session.createQuery("from Employee").getResultList();
        return employees;
    }
    
    public Employee getEmployee(int id) {
        Session session = this.entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class,id);
        return employee;
    }
 
    public void saveEmployee(Employee employee) {
        Session session = this.entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }
}
