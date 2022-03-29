package com.example.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.example.security.api.Appconstant;
import com.example.security.entity.APUserDetails;
import com.example.security.entity.APUsers;
import com.example.security.handlers.ApiErrorInfo;
import com.example.security.repository.UserRepository;
@Component
public class LoginUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
    public UserDetails loadUserByUsername(String username){
        APUsers user = userRepository.findByEmail(username);
        if (user == null) {
            throw new ApiErrorInfo("1000",Appconstant.NOT_FOUND_IN_SYSTEM);
        }
        return new APUserDetails(user);
    }
}
