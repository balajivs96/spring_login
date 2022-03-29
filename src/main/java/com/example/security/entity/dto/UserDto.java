package com.example.security.entity.dto;

public class UserDto {
	private long id;
    private String email;
    private String password;
    private UserDetailsDto userDetails;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserDetailsDto getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetailsDto userDetails) {
		this.userDetails = userDetails;
	}
}
