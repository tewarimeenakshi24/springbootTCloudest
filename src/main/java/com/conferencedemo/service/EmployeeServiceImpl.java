package com.conferencedemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conferencedemo.model.Employee;
import com.conferencedemo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
		
	}

	@Override
	public Optional<Employee> findById(String empNo) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(empNo);
	}

	@Override
	public void deleteById(String empNo) {
		employeeRepository.deleteById(empNo);
		
	}


}
