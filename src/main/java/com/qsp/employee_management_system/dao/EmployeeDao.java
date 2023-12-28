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
	public List<Employee> saveAll(List<Employee> list) {
    	return repo.saveAll(list);
		
	}

	public Employee updatePhone(int id, long phone) {
		Optional<Employee> optional=repo.findById(id);
		if (optional.isPresent()) {
			Employee employee=optional.get();
			employee.setPhone(phone);
			return repo.save(employee);
		}
		return null;
	}

	public Employee updateEmail(int id, String email) {
		Optional<Employee> optional=repo.findById(id);
		if (optional.isPresent()) {
			Employee employee=optional.get();
			employee.setEmail(email);
			return repo.save(employee);
		}
		return null;
	}

	public Employee updateSalary(int id, double salary) {
		Optional<Employee> optional=repo.findById(id);
		if (optional.isPresent()) {
			Employee employee=optional.get();
			employee.setSalary(salary);
			return repo.save(employee);
		}
		return null;
	}
    //find by phone		
	public Employee findByPhone(long phone) {
		return repo.findEmployeeByPhone(phone);
	}
    //get by email
	public Employee findByEmail(String email) {
		return repo.getEmployeeByEmail(email);
	}

	public List<Employee> findByAddress(String address) {
		return repo.empByAddress(address);
	}

	public List<Employee> findByName(String name) {
		return repo.empByName(name);
	}

}
