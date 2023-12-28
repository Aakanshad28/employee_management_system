package com.qsp.employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.employee_management_system.dao.EmployeeDao;
import com.qsp.employee_management_system.dto.Employee;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeDao dao;

	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return dao.saveEmployee(employee);

	}

	@GetMapping("/fetch")
	public Employee findEmployee(@RequestParam int id) {
		return dao.findEmployee(id);

	}

	@GetMapping("/fetchAll")
	public List<Employee> findAllEmployee() {
		return dao.findAllEmployee();
	}

	@DeleteMapping("/delete/{id}")
	public Employee deleteEmployee(@PathVariable int id) {
		return dao.deleteEmployee(id);

	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestParam int id, @RequestBody Employee employee) {
		return dao.updateEmployee(id, employee);
	}

	@PostMapping("/saveall")
	public List<Employee> saveAll(@RequestBody List<Employee> list) {
		return dao.saveAll(list);

	}

	@PatchMapping("/updatephone")
	public Employee updatePhone(int id, long phone) {
		return dao.updatePhone(id, phone);

	}

	@PatchMapping("/updateemail")
	public Employee updateEmail(int id, String email) {
		return dao.updateEmail(id, email);

	}

	@PatchMapping("/updatesalary")
	public Employee updateSalary(int id, double salary) {
		return dao.updateSalary(id, salary);

	}

	// update name
	@GetMapping("/findbyphone")
	public Employee findByPhone(long phone) {
		return dao.findByPhone(phone);

	}

	@GetMapping("/findbyemail")
	public Employee findByEmail(String email) {
		return dao.findByEmail(email);

	}
	@GetMapping("/findbyaddress")
	public List<Employee> findByAddress(String address) {
		return dao.findByAddress(address);
		
	}
	//find by name
	@GetMapping("/findbyname")
	public List<Employee> findByname(String name) {
		return dao.findByName(name);
	}
}
