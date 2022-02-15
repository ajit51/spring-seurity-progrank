package com.progrank.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.progrank.security.model.User;
import com.progrank.security.repository.UserRepository;

public class LoginUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository rep;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user = rep.findByusername(username);
		User u = user.orElseThrow(() -> new UsernameNotFoundException("User not fount !!"));
		
		return new LoginUserDetails(u);
	}

}
