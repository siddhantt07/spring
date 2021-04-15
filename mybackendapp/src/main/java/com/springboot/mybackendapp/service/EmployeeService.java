package com.springboot.mybackendapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.mybackendapp.dao.EmployeeDao;
import com.springboot.mybackendapp.entity.Employee;

@Service
public class EmployeeService {

	
	private EmployeeDao employeeDao;
	@Autowired
	public EmployeeService(EmployeeDao theemployeeDao) {
		employeeDao=theemployeeDao;
	}
	
	@Transactional
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

	@Transactional
	public void saveEmployee(Employee employee) {

		employeeDao.saveEmployee(employee);
	}

	@Transactional
	public Employee getEmployee(int id) {
		
		return employeeDao.getEmployee(id);
	}
}
