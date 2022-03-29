package com.example.security.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.security.entity.APUsers;
import com.example.security.entity.dto.LoginDTO;

@Component
public interface UsersService {
	APUsers registerUser(APUsers user);
	List<APUsers> getAllUsers();
	String login(LoginDTO login);
	HashMap<String, Object> getProfile(String email);
}
