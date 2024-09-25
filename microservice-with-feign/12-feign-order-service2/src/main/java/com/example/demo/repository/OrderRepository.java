package com.example.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.OrderCustomer;

@Repository
public interface OrderRepository extends JpaRepository<OrderCustomer, Long> {
    // Method to find all orders for a specific customer ID
	List<OrderCustomer> findByCustomerId(Long customerId);
}