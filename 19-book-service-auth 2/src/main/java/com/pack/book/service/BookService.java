package com.pack.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pack.book.feign.AuthFeign;

@Service
public class BookService {
	 @Autowired (required = true)
	 AuthFeign authFeign;
	 
	 public boolean hasPermission(String token) {
		 return  authFeign.getTokenValidity(token);
	 } 
	 }
