package com.qsp.employee_management_system.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.qsp.employee_management_system.dto.Employee;
import com.qsp.employee_management_system.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	@Autowired
	private EmployeeRepo repo;
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);

	}
	 public Employee findEmployee( int id) {
		return repo.findById(id).get();
	    	
			
		}

}
