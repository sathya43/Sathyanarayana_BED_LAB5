package com.management.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.management.employee.entity.Employee;
import com.management.employee.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
    @GetMapping
    @ApiOperation(value = "Get all employee", notes = "This API is used to get all employees and display them on thymleaf UI page")
	public String Home(Model theModel) {
        theModel.addAttribute("allemplist",employeeService.getAllEmployee());	
		return "index";
	}

	@PostMapping
	@ApiOperation(value = "Register and Save a New Employee", notes = "This API is used to save the details of new employee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
	    employeeService.save(employee);
		return "redirect:/employees";
	}
	

	@GetMapping("/{id}")
	@ApiOperation(value = "Delete an Employe with ID", notes = "This API is used to delete the employee whose ID is passed as parameter")
	public String deleteThroughID(@PathVariable(value = "id") Long id) {
		employeeService.deleteByID(id);
		return "redirect:/employees";
        
	}
}
