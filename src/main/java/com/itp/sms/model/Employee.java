package com.itp.sms.model;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eno;
	
	@NotNull
	@Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters") 
	private String firstName;
	
	@NotNull(message="Email cannot be null")
	@Email(message="Invalid Email format")
	@Column(unique = true)
	private String email;
	
	@NotNull(message="Password cannot be null")
	@Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters") 
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Password must be alphanumeric")
	private String password;
	
	@NotNull(message = "Mobile number cannot be null") 
	@NotEmpty(message = "Mobile number cannot be empty") 
	@Pattern(regexp = "^[6-9][0-9]{9}$", message = "Mobile number must start with 6, 7, 8, or 9 and be 10 digits long")
	@Column(unique = true)
	private String mobileNumber;
	
	
	@NotNull(message = "Salary cannot be null") 
	@Min(value = 10000, message = "Salary must be at least 10,000") 
	@Max(value = 50000, message = "Salary must be less than or equal to 50,000") 
	private Integer salary;
	
	
//	@CreatedDate 
//	@Column(name = "created_at") 
//	private Timestamp createdAt; 
//
//	@LastModifiedDate 
//	@Column(name = "modified_at") 
//	private Timestamp modifiedAt;

}
