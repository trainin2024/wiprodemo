package com.jwt.api.controller;


import com.jwt.api.entity.*;
import com.jwt.api.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/") // Protected 
    public String welcome() {
        return "Welcome to java !!";
    }


    
    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }

    
    
    @GetMapping(value = "/validate")
	public boolean getValidation(@RequestHeader("Authorization") String token){
		token = token.substring(7);
		com.jwt.api.entity.AuthResponse auth = new AuthResponse();
	
		//log.info("Token validation for "+jwtUtil.extractUsername(token));
		
		if(jwtUtil.validateToken(token)) {
			
			System.out.println("Token validated");
			return true;
		}
		else {
			System.out.println("Token NOT validated");
			return false;

	}
    }}


