package com.jwt.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//DTO Class
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class AuthRequest {

    private String userName;
    private String password;
	public String getUserName() {
		return userName;
	}
	
	public AuthRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AuthRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
    
    
    
}
