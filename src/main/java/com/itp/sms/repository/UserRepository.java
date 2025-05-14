package com.itp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.sms.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
	
	public User findByUsername(String x);
}
