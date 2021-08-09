package com.lets.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lets.model.UserModel;
import com.lets.service.AuthenticationService;
import com.lets.view.LoginView;

@RestController
@RequestMapping("/lets")
public class Authentication {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/register")
	public String register(@RequestBody LoginView login) {
		return authenticationService.register(login);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody LoginView login) {
		return authenticationService.login(login);
	}
	
	@GetMapping("/hello/{name}")
	public String getName(@PathVariable String name) {
		return "hello " + name;
	}
	
}
