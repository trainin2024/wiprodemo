package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.client.CustomerClient;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.OrderCustomer;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
	 @Autowired
	    private OrderRepository orderRepository;
	 
	 @Autowired
	    private CustomerClient customerClient;
	
	
	 public List<OrderDTO> getOrdersForCustomerById(Long customerId) {
		System.out.println(" customerID: "+customerId);
	        // Fetch orders associated with the customer ID
		List<OrderCustomer> orders = orderRepository.findByCustomerId(customerId);
		
        
        if (orders.isEmpty()) {
            logger.warn("No orders found for customer ID: {}", customerId);
        } else {
            logger.info("Found {} orders for customer ID: {}", orders.size(), customerId);
        }
	        // Convert each OrderCustomer to OrderDTO
	       return orders.stream()
	                   .map(this::convertToDTO) // Use your manual conversion method
	                    .collect(Collectors.toList());
	 }
     
	    
	        
     public OrderDTO convertToDTO(OrderCustomer orderCustomer) {
		    if (orderCustomer == null) {
		        return null;
		    }

		    OrderDTO orderDTO = new OrderDTO();
		    orderDTO.setId(orderCustomer.getId());
		    orderDTO.setProduct(orderCustomer.getProduct());
		    orderDTO.setCustomerId(orderCustomer.getCustomerId());
		    
		    return orderDTO;
		}
	    }
	    

	   
