package com.itp.sms.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	private String username;
	private String password;
	private LocalDate accountExpiryDate;  
    private int accountLockedStatus;  //1-Non Locked 0-locked
    private LocalDate credentialsExpiryDate;
	private int accountEnabledStatus; //1-Enabled 0-Disabled
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	   @JoinTable(
	           name = "itpuserroles",
	           joinColumns = @JoinColumn(name = "fuserid"),
	           inverseJoinColumns = @JoinColumn(name = "froleid")
	           )
	List<Role> roles;

}
