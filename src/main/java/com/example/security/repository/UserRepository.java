package com.example.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.security.entity.APUsers;

@Repository
public interface UserRepository extends JpaRepository<APUsers, Long> {

	@Query(value = "SELECT * FROM ap_user u WHERE u.email = :email", nativeQuery = true)
	public APUsers findByEmail(String email);
	
	//https://www.codejava.net/frameworks/spring-boot/user-registration-and-login-tutorial
}
