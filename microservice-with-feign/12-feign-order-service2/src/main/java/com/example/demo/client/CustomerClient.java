package com.example.demo.client;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.CustomerDTO;

@org.springframework.cloud.openfeign.FeignClient(name = "customer-service", url = "http://localhost:9000") // Change URL as needed
public interface CustomerClient {
    @GetMapping("/customers/{id}")
    CustomerDTO isValidCustomer(@PathVariable("id") Long customerId);
}
