package com.example.security.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.security.api.Appconstant;
import com.example.security.entity.dto.LoginDTO;
import com.example.security.handlers.ApiErrorInfo;
import com.example.security.service.LoginUserDetailsService;

@Service
public class LoginUserDetailsServiceImpl {

	private LoginUserDetailsService loginUserDetailsService;
	private BCryptPasswordEncoder encoder;

	@Autowired
	public LoginUserDetailsServiceImpl(LoginUserDetailsService loginUserDetailsService, BCryptPasswordEncoder encoder) {
		super();
		this.loginUserDetailsService = loginUserDetailsService;
		this.encoder = encoder;
	}

	public String logininfo(LoginDTO login) {
		UserDetails logininfo = loginUserDetailsService.loadUserByUsername(login.getEmail());
		if (logininfo.getUsername().equals(login.getEmail())
				&& encoder.matches(login.getPassword(), logininfo.getPassword())) {
			return Appconstant.LOGIN_SUCCESS;
		} else {
			throw new ApiErrorInfo("1000", Appconstant.INVALID_EMAIL_OR_PASSWORD);
		}
	}
}
