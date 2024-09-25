package com.example.demo.dto;

import java.util.List;

public class CustomerOrderDTO {
	    private Long id;
	    private String name;
	   private List<OrderDTO> orders;
	    
	    

	    // Default constructor
	    public CustomerOrderDTO() {
	    }

	    // Constructor with parameters
	    public CustomerOrderDTO(Long id, String name) {
	        this.id = id;
	        this.name = name;
	    }

	    // Getters and setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

		public List<OrderDTO> getOrders() {
			return orders;
		}

		public void setOrders(List<OrderDTO> orders) {
			this.orders = orders;
		}
	    
	    
	}