package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
//http://localhost:8000/order/1/orders
@SpringBootApplication
@EnableFeignClients
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

/*
 * [
    {
        "id": 1,
        "product": "Mobile",
        "customerId": 1
    },
    {
        "id": 2,
        "product": "TV",
        "customerId": 1
    }
]*/
 