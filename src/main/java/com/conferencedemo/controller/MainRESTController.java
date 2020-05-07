package com.conferencedemo.controller;

import java.util.List;
import java.util.Optional;

import com.conferencedemo.dao.EmployeeDAO;
import com.conferencedemo.model.Employee;
import com.conferencedemo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRESTController {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Autowired
	private EmployeeService employeeService;
	
	//find all employees
		@RequestMapping(value = "listEmployees", method = RequestMethod.GET)
		public List<Employee> ListEmployees(){
			return employeeService.findAll();
		}
		
		//find an employee by emp no
		@RequestMapping(value = "employee/{empNo}", method = RequestMethod.GET)
		public Optional<Employee> getEmployee1(@PathVariable("empNo") String empNo){
			return employeeService.findById(empNo);
		}
		
		//delete an emp
		@RequestMapping(value = "deleteemployee/{empNo}", method = RequestMethod.POST)
		public String delEmployee(@PathVariable("empNo") String empNo){
			employeeService.deleteById(empNo);
			return "Employee Deleted " + empNo;
		}
		
		//update an employee
		@RequestMapping(value = "createUpdateEmp", method = RequestMethod.PUT)
		public Employee updateEmployee1(@RequestBody Employee emp) {
			 System.out.println("(Service Side) Editing employee: " + emp.getEmpNo());
			return employeeService.save(emp);
		}
		
	@RequestMapping("/")
	public String welcome() {
		return "Welcome to RestTemplate Demo.";
	}



	/*
	 * // URL - http://localhost:8080/employees
	 * 
	 * @RequestMapping(value = "/employees", // method = RequestMethod.GET, //
	 * produces = { MediaType.APPLICATION_JSON_VALUE }) public List<Employee>
	 * getEmployees() { List<Employee> list = employeeDAO.getAllEmployees(); return
	 * list; }
	 * 
	 * // URL - http://localhost:8080/employee/{empNo}
	 * 
	 * @RequestMapping(value = "/employee/{empNo}", // method = RequestMethod.GET,
	 * // produces = { MediaType.APPLICATION_JSON_VALUE }) public Employee
	 * getEmployee(@PathVariable("empNo") String empNo) { return
	 * employeeDAO.getEmployee(empNo); }
	 * 
	 * // URL - http://localhost:8080/employee
	 * 
	 * @RequestMapping(value = "/employee", // method = RequestMethod.POST, //
	 * produces = { MediaType.APPLICATION_JSON_VALUE }) public Employee
	 * addEmployee(@RequestBody Employee emp) {
	 * 
	 * System.out.println("(Service Side) Creating employee: " + emp.getEmpNo());
	 * 
	 * return employeeDAO.addEmployee(emp); }
	 * 
	 * // URL - http://localhost:8080/employee
	 * 
	 * @RequestMapping(value = "/employee", // method = RequestMethod.PUT, //
	 * produces = { MediaType.APPLICATION_JSON_VALUE }) public Employee
	 * updateEmployee(@RequestBody Employee emp) {
	 * 
	 * System.out.println("(Service Side) Editing employee: " + emp.getEmpNo());
	 * 
	 * return employeeDAO.updateEmployee(emp); }
	 * 
	 * // URL - http://localhost:8080/employee/{empNo}
	 * 
	 * @RequestMapping(value = "/employee/{empNo}", // method =
	 * RequestMethod.DELETE, // produces = { MediaType.APPLICATION_JSON_VALUE })
	 * public void deleteEmployee(@PathVariable("empNo") String empNo) {
	 * 
	 * System.out.println("(Service Side) Deleting employee: " + empNo);
	 * 
	 * employeeDAO.deleteEmployee(empNo); }
	 */

}