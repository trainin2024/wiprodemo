package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.CustomerOrderDTO;
import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/{id}") //convert the Customer to CustomerDTO
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id).get();
        return com.example.demo.MapperConfig.getModelMapper().map(customer, CustomerDTO.class);
        
    }
    
   /* @GetMapping("/myorders/{id}") //convert the Customer to CustomerDTO
    public List<OrderDTO> getAllOrdersByCustomerById(@PathVariable Long id) {
    		return customerService.findAllOrdersByCustomerId(id);
    } */
    
    @GetMapping("/myorders/{id}") //convert the Customer to CustomerDTO
    public CustomerOrderDTO getAllOrdersByCustomerById(@PathVariable Long id) {
    		return customerService.findAllOrdersByCustomerId(id);
    } 
}