package com.qsp.employee_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qsp.employee_management_system.dto.Employee;
import com.qsp.employee_management_system.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	@Autowired
	private EmployeeRepo repo;

	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);

	}

	public Employee findEmployee(int id) {
		
		//return repo.findById(id).get();
		//to avoid no such element exception
		
		Optional<Employee> optional=repo.findById(id);
		if (optional.isPresent()) {
			if (optional.isEmpty()) {
				return optional.get();
				//return null
			}
			return null;
			//return optional.get();
		}
		return null;

	}

	public List<Employee> findAllEmployee() {
        return repo.findAll();
        
	}

	public Employee deleteEmployee(int id) {
		Optional<Employee> optional=repo.findById(id);
		if (optional.isPresent()) {
			//repo.deleteById(id);
//			return optional.get();
			
			Employee employee=optional.get();
			repo.delete(employee);
			return employee;
			
		}
		return null;
	}

	public Employee updateEmployee(int id, Employee employee) {
		Optional<Employee> optional=repo.findById(id);
		if (optional.isPresent()) {
			employee.setId(id);
			return repo.save(employee);
		}
		return null;
	}
	
	

}
