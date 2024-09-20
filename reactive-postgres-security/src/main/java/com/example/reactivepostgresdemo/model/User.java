package com.example.reactivepostgresdemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
@Table
public class User {
	@Id
    private Integer id;
    private String username;
    private String password; // Store hashed passwords in production
	public User(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		super();
		
	}
    
    
}
