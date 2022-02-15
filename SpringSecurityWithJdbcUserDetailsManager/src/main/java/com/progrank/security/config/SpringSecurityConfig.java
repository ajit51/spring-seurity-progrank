package com.progrank.security.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	  @Bean public UserDetailsManager userDetailsManager() { return new
	  JdbcUserDetailsManager(dataSource()); }
	  
	  @Bean public DataSource dataSource() { return new
	  DriverManagerDataSource("jdbc:mysql://localhost/test", "root", "root"); }
	  
	  @Bean
	  public PasswordEncoder encoder() {
		  return NoOpPasswordEncoder.getInstance();
	  }
	 
	  @Override
	protected void configure(HttpSecurity http) throws Exception {
		  http
		  .csrf()
		  .disable()
		  .authorizeRequests()
		  .mvcMatchers("/createUser").permitAll()
		  .anyRequest()
		  .authenticated();
	}
}
