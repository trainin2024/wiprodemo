package com.example.reactivepostgresdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reactive.postgresdemo.service.UserService;
import com.example.reactive.postgresdemo.util.JwtUtil;
import com.example.reactivepostgresdemo.model.LoginRequest;
import com.example.reactivepostgresdemo.model.User;
import com.example.reactivepostgresdemo.repo.UserRepository;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Autowired
	JwtUtil jwtUtil;

	@PostMapping("/login")
	public Mono<ResponseEntity<String>> login(@RequestBody LoginRequest loginRequest) {
		return userRepository.findByUsername(loginRequest.getUsername()).flatMap(user -> {
			// Here, you should check the password against the stored hashed password
			if ("valid_password".equals(loginRequest.getPassword())) { // Use password hashing in production
				String token = jwtUtil.generateToken(user.getUsername());
				return Mono.just(ResponseEntity.ok(token));
			} else {
				return Mono.just(ResponseEntity.status(401).body("Unauthorized"));
			}
		}).switchIfEmpty(Mono.just(ResponseEntity.status(401).body("Unauthorized")));
	}

	@PostMapping("/register")
	public Mono<ResponseEntity<String>> register(@RequestBody User user) {
		user.setPassword(userService.encodePassword(user.getPassword()));
		System.out.println(user.getPassword()+user.getUsername());
		return userRepository.save(user).map(savedUser -> ResponseEntity.ok("User registered successfully"))
				.defaultIfEmpty(ResponseEntity.status(400).body("User registration failed"));
	}

}
