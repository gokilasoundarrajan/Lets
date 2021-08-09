package com.lets.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lets.model.LoginModel;
import com.lets.model.UserModel;
import com.lets.repository.LoginRepository;
import com.lets.repository.UserRepository;
import com.lets.view.LoginView;

@Service
public class AuthenticationService {
	
	@Autowired
	LoginRepository loginRepository;
	
	public String login(LoginView login) {
		LoginModel loginModel = new LoginModel();
		loginModel.setUserName(login.getUserName());
		loginModel.setPassword(login.getPassword());
		Optional<LoginModel> result = loginRepository.findByUsername(loginModel.getUserName());
		return "Authenticated" + result.toString();
	}

	public String register(LoginView login) {

		Optional<LoginModel> result = loginRepository.findByUsername(login.getUserName());
		if(result.isPresent())
			return "Not Registerd: Email already Exist";
		LoginModel loginData = new LoginModel();
		loginData.setUserName(login.getUserName());
		loginData.setPassword(login.getPassword());
		loginRepository.save(loginData);
		return "registered" + login.getUserName();
	}
	
}
