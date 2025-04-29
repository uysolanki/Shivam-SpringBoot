package com.itp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.sms.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

}
