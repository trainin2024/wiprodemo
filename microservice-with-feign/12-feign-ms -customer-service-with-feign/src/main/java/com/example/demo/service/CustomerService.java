package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.OrderClient;
import com.example.demo.dto.CustomerOrderDTO;
import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
   @Autowired
   CustomerRepository customerRepository;
   
   @Autowired
   OrderClient  orderClient;
    /*@Autowired
    public CustomerService() {
        // Sample data
        customers.add(new Customer(1L, "mark "));
        customers.add(new Customer(2L, "johnson"));
    }*/

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
    	return customerRepository.findById(id);
                
    }
    
  /*  public List<OrderDTO> findAllOrdersByCustomerId(Long customerId)
    {
    	return orderClient.getOrderByCustomerId(customerId);
    }*/
    
    public CustomerOrderDTO findAllOrdersByCustomerId(Long customerId)
    {
    	List<OrderDTO> orderlist= orderClient.getOrderByCustomerId(customerId);
    	CustomerOrderDTO customeOrderDTO = new CustomerOrderDTO();
    	customeOrderDTO.setId(customerId);
    	customeOrderDTO.setName(customerRepository.getById(customerId).getName());
    	customeOrderDTO.setOrders(orderlist);
    	return customeOrderDTO;
    	
    }
}