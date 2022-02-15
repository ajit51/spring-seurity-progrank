package com.progrank.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.progrank.security.model.User;
import com.progrank.security.service.MyUserService;

@RestController
public class MyController {
	
	@Autowired
	private MyUserService myUserService;
	
	@GetMapping("/index")
	public String index() {
		return "Hello Spring Security Using JDBCUserDetailsManaer !!";
	}
	
	@PostMapping("/createUser")
	public void createUser(@RequestBody User user) {
		myUserService.addUser(user);
	}

}
