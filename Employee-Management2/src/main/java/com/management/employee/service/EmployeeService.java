package com.management.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.management.employee.entity.Employee;


public interface EmployeeService {
    List<Employee> getAllEmployee();
    void save(Employee employee);
    Employee  getById(Long id);
    String deleteByID(Long id);
}