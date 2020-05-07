package com.conferencedemo.service;

import java.util.List;
import java.util.Optional;

import com.conferencedemo.model.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();

	Employee save(Employee emp);

	Optional<Employee> findById(String empNo);

	void deleteById(String empNo);
}
