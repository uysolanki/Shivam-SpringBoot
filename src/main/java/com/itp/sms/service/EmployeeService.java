package com.itp.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.sms.model.Employee;
import com.itp.sms.model.Player;
import com.itp.sms.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(int eno, Employee employee) {
		Employee empDB=employeeRepository.findById(eno).get();
		empDB.setEmail(employee.getEmail());
		empDB.setFirstName(employee.getFirstName());
		empDB.setMobileNumber(employee.getMobileNumber());
		empDB.setPassword(employee.getPassword());
		empDB.setSalary(employee.getSalary());
		
		return employeeRepository.save(empDB);
	}

}
