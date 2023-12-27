package com.qsp.employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
    public Employee updateEmployee(@RequestParam int id,@RequestBody Employee employee) {
    	return dao.updateEmployee(id,employee);
    }

}
