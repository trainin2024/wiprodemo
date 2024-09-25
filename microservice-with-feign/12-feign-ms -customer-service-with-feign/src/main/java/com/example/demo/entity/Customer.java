package com.example.demo.entity;
import java.util.HashSet;
import java.util.Set;


import com.example.demo.dto.OrderDTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@jakarta.persistence.Entity
@jakarta.persistence.Table(name="customer1")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    // Getters and Setters
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

	public Customer(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
    


}