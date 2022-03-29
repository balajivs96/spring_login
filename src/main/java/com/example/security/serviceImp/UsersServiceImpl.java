package com.example.security.serviceImp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.security.api.Appconstant;
import com.example.security.entity.APUsers;
import com.example.security.entity.dto.LoginDTO;
import com.example.security.handlers.ApiErrorInfo;
import com.example.security.repository.UserRepository;
import com.example.security.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder encode;

	@Autowired
	private LoginUserDetailsServiceImpl loginUserDetailsServiceImpl;

	@Override
	public APUsers registerUser(APUsers user) {
		user.getUserDetails().setUser(user);
		user.setPassword(encode.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public List<APUsers> getAllUsers() {
		List<APUsers> all = userRepository.findAll();
		if (all.isEmpty()) {
			throw new ApiErrorInfo("1000", Appconstant.USER_IS_EMPTY);
		} else {
			return all;
		}
	}

	@Override
	public String login(LoginDTO login) {
		return loginUserDetailsServiceImpl.logininfo(login);
	}

	@Override
	public HashMap<String, Object> getProfile(String email) {
		APUsers user = userRepository.findByEmail(email);
		HashMap<String, Object> profile = new HashMap<String, Object>();
		if (user != null) {
			profile.put("email", user.getEmail());
			profile.put("firstName", user.getFirstName());
			profile.put("lastName", user.getLastName());
			profile.put("id", user.getId());
			profile.put("userDetails", user.getUserDetails());
			return profile;
		} else {
			throw new ApiErrorInfo("1000", Appconstant.PLEASE_LOGIN);
		}
	}

}
