package com.itp.sms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itp.sms.model.Employee;
import com.itp.sms.model.Player;
import com.itp.sms.service.EmployeeService;
import com.itp.sms.util.APIError;


@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<?> addEmployee(@RequestBody @Valid Employee employee,BindingResult bindingResult)
	{
		
		if(bindingResult.hasErrors())
		{
			List<APIError> errors=new ArrayList();
			for(FieldError error :bindingResult.getFieldErrors())
			{
				APIError myError=new APIError(error.getDefaultMessage(), error.getField(), error.getRejectedValue());
				errors.add(myError);
			}
			return new ResponseEntity<List<APIError>>(errors,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Employee>(employeeService.addEmployee(employee),HttpStatus.CREATED);
	}
	
	@PutMapping("/updateEmployee/{eno}") //10000
	public ResponseEntity<Employee> updateEmployee(@PathVariable int eno, @RequestBody Employee employee)
	{
		Employee employee1=employeeService.updateEmployee(eno,employee);
		return new ResponseEntity<Employee>(employee1,HttpStatus.OK);
	}

}
