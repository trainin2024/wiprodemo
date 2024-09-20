package com.example.reactivepostgresdemo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.annotation.security.RolesAllowed;

@Table
//@Data				
//@AllArgsConstructor
//@NoArgsConstructor
/* select * from customer;
 * create table customer (id serial primary key,name text)
 * insert into customer (id, name) values (100,'Alex');
 * */
public class Customer {
    @Id
    private Integer id;
    @Column
    private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Customer(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}  
}
//Lombok https://www.javaguides.net/2019/05/how-to-use-lombok-in-java-project-and.html