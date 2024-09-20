package com.example.reactive.postgresdemo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.example.reactive.postgresdemo.util.JwtUtil;

import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

	@Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

	@Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http.csrf().disable() // Disable CSRF protection entirely
            .authorizeExchange()
            .pathMatchers("/user/login", "/user/register").permitAll() // Allow access to these endpoints
            .pathMatchers("/customer/**").authenticated() // Secure customer endpoints
            .anyExchange().permitAll() // Allow all other requests
            .and()
            .addFilterBefore(jwtAuthenticationFilter, SecurityWebFiltersOrder.AUTHORIZATION); // Add your JWT filter

        return http.build();
    }
		
        
}
