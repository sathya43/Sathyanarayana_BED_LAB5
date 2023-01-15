package com.management.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.management.employee.entity.Employee;
import com.management.employee.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/employees")
public class FormController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/updateInfo/{id}")
	@ApiOperation(value = "Fetches the Update form", notes = "This API is used fetch and display the Update form")
	public String updateEmployee(@PathVariable(value = "id") Long id, Model theModel) {
		Employee employee = employeeService.getById(id);
		theModel.addAttribute("employee",employee);
		return "update";
	}
	
	@GetMapping("/register")
	@ApiOperation(value = "Fetches employee registration form", notes = "This API is used fetch and display the employee registration form")
	public String newEmployee(Model theModel) {
		Employee employee = new Employee();
		theModel.addAttribute("employee",employee);
		return "newEmployee";
	}

}
