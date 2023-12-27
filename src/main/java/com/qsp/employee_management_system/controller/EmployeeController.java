package com.qsp.employee_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

}
