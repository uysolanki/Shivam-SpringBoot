package com.itp.sms.security;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.itp.sms.model.Role;
import com.itp.sms.model.User;

public class MyITPDecorator implements UserDetails {

	User user;
	
	public MyITPDecorator(User user)
	{
		this.user=user;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRolename()));
        }
         
        return authorities;

	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() 
	{
		LocalDate expiryDate=user.getAccountExpiryDate();  //14-May-2026
		LocalDate todaysDate=LocalDate.now();              //16-May-2026
		if(todaysDate.isAfter(expiryDate))
			return false;
		else
			return true;
		
		
	}

	@Override
	public boolean isAccountNonLocked() {
		int accLockedStatus=user.getAccountLockedStatus();
		if(accLockedStatus==1)
			return true;
		else
			return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		LocalDate credExpiryDate=user.getCredentialsExpiryDate();  //14-Aug-2025
		LocalDate todaysDate=LocalDate.now();                      //15-Aug-2025
		if(todaysDate.isAfter(credExpiryDate))
			return false;
		else
			return true;
	}

	@Override
	public boolean isEnabled() {
		int accEnabledStatus=user.getAccountEnabledStatus();
		if(accEnabledStatus==1)
			return true;
		else
			return false;
	}

}
