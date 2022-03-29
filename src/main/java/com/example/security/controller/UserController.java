package com.example.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.api.ApiResponse;
import com.example.security.entity.APUsers;
import com.example.security.entity.dto.LoginDTO;
import com.example.security.serviceImp.UsersServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	private UsersServiceImpl usersServiceImpl;
	
	@GetMapping("/")
	private ApiResponse Hello() {
		ApiResponse res = new ApiResponse();
		res.setData("Hello world");
		res.setErrorVM(null);
		res.setStatus(HttpStatus.OK.value());
		return res;
	}
	
	@PostMapping("/register")
	private ApiResponse registration(@RequestBody APUsers user) {
		ApiResponse res = new ApiResponse();
		res.setData(usersServiceImpl.registerUser(user));
		res.setErrorVM(null);
		res.setStatus(HttpStatus.OK.value());
		return res;
	}
	
	@GetMapping("/users")
	private ApiResponse getAllUsers() {
		ApiResponse res = new ApiResponse();
		res.setData(usersServiceImpl.getAllUsers());
		res.setErrorVM(null);
		res.setStatus(HttpStatus.OK.value());
		return res;
	}
	
	@PostMapping("/login")
	private ApiResponse login(@RequestBody LoginDTO login) {
		ApiResponse res = new ApiResponse();
		res.setData(usersServiceImpl.login(login));
		res.setErrorVM(null);
		res.setStatus(HttpStatus.OK.value());
		return res;
	}
	
	@GetMapping("/profile")
	private ApiResponse getProfile(@RequestHeader String email) {
		ApiResponse res = new ApiResponse();
		res.setData(usersServiceImpl.getProfile(email));
		res.setErrorVM(null);
		res.setStatus(HttpStatus.OK.value());
		return res;
	}
}
