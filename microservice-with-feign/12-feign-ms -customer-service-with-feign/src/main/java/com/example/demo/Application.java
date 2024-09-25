package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//http://localhost:9000/customers/myorders/1

@SpringBootApplication
@EnableFeignClients
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
/*
 * 
    "id": 1,
    "name": "mac2",
    "orders": [
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
    ]
}*/
 */