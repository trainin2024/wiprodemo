package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}



/* 0. Create a git repo say : https://github.com/fortrainees2020/spring-config-repo.git
 * 	- Create application.properties file.
 	name = Synechron
	spring.datasource.url=jdbc:mysql://localhost:3306/microdb
	spring.datasource.username=root
	spring.datasource.password=rootroot
	spring.jpa.hibernate.ddl-auto=update
	spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
	
 *  - Create productws.properties file 
 -------------------------------------
 	yourname = Alex
 	
 * 1. Create a config server and map it to local and git url
 * 	a. add dependency 
 * 	- <dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-config-server</artifactId>
			</dependency>
	  </dependencies>
	 
 *  b. Annotate main() with @EnableConfigServer
 *  c. Create properties file 
 * 	spring.application.name = configserver
	server.port= 7000
	spring.cloud.config.server.git.uri = https://github.com/fortrainees2020/spring-config-repo
	spring.cloud.config.server.git.clone-on-start=true
 -----------------------------------------
 * 2. Create a config client
 * 
 * 3. Create bootstrap.properties  file 
 * 	spring.application.name=productws
	spring.cloud.config.uri=http://localhost:7000
	spring.cloud.config.name= configserver
	spring.cloud.config.name=productws
	
  4. create application.properties file 
    server.port=9090
	spring.profiles.active = native
	
  5. Access  data from config server
  @Value("${name}")
		  private String username;
		
		@Value("${yourname}")
		  private String friend;
	   
	    @GetMapping(path = "/")
	    String getMessage() {
	        return "Welcome to "+  username +"  "+friend;
	    }
 * */
}
