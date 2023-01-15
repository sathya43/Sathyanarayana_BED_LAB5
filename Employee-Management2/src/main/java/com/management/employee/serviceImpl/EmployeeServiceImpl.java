package com.management.employee.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.employee.entity.Employee;
import com.management.employee.repository.EmployeeRepository;
import com.management.employee.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee getById(Long id) {
		Employee employee = null;
		Optional<Employee> optional = employeeRepository.findById(id);
		if(optional.isPresent()) {
			employee = optional.get();
		}else {
			throw new RuntimeException("Employee not found for id: " + id);
		}
		return employee;
	}

	@Override
	public String deleteByID(Long id) {
		employeeRepository.deleteById(id);
		return "redirect:/";
	}






}
