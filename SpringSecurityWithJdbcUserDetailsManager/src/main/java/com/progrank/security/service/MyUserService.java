package com.progrank.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.progrank.security.model.User;

@Service
public class MyUserService {
	
	@Autowired
	private UserDetailsManager userDetailsManager;
	
	public void addUser(User user) {
		userDetailsManager.createUser(user);
	}

}
