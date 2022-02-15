package com.progrank.security.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.progrank.security.auth.UserPasswordAuthToken;
import com.progrank.security.service.MyUserDetailsService;

@Component
public class UserPasrswordAuthProvider implements AuthenticationProvider{
	
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		UserDetails userDetails = myUserDetailsService.loadUserByUsername(authentication.getName());
		if(passwordEncoder.matches(authentication.getCredentials() +"", userDetails.getPassword())) {
			return new UserPasswordAuthToken(userDetails.getUsername(), 
					userDetails.getPassword(),
					userDetails.getAuthorities());
		}
		throw new BadCredentialsException("Failed User Exception !!");
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UserPasswordAuthToken.class.equals(authentication);
	}

}
