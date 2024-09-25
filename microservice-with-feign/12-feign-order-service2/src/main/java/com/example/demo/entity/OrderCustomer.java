package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer_order4")
public class OrderCustomer {
    
    @Id
    @jakarta.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String product;
    
    @Column
    private Long customerId;

    // Default constructor
    public OrderCustomer() {
    }

    // Parameterized constructor
    public OrderCustomer(String product, Long customerId) {
        this.product = product;
        this.customerId = customerId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}