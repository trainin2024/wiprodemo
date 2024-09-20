package com.example.reactive.postgresdemo.config;

	import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
	import org.springframework.security.core.context.SecurityContextHolder;
	import org.springframework.stereotype.Component;
	import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import com.example.reactive.postgresdemo.util.JwtUtil;

import reactor.core.publisher.Mono;

	@Component
	public class JwtAuthenticationFilter implements WebFilter {

	    @Autowired
	    private JwtUtil jwtUtil;

	    @Override
	    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
	        String token = exchange.getRequest().getHeaders().getFirst("Authorization");
	        if (token != null && token.startsWith("Bearer ")) {
	            token = token.substring(7); // Remove "Bearer "
	            String username = jwtUtil.extractUsername(token);
	            if (username != null && jwtUtil.validateToken(token, username)) {
	                UsernamePasswordAuthenticationToken authentication =
	                    new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
	                SecurityContextHolder.getContext().setAuthentication(authentication);
	            } else {
	                return Mono.error(new RuntimeException("Invalid JWT token"));
	            }
	        }
	        return chain.filter(exchange);
	    }

	}



