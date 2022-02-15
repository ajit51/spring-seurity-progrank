package com.progrank.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SpringSecurityWithMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityWithMySqlApplication.class, args);
	}

}
