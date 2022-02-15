package com.progrank.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager ud = new InMemoryUserDetailsManager();
		
		UserDetails user = User.withUsername("Ajit")
		.password("23")
		.authorities("read")
		.build();
		
		ud.createUser(user);
		
		return ud;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
