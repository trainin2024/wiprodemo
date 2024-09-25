package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrderDTO;
import com.example.demo.service.OrderService;


@RestController
@RequestMapping("/order") //http://localhost:8000/order/1/orders
public class OrderController {
	@Autowired
    private OrderService orderService;

   @GetMapping
   public String hello()
   {
	   return "Hello";
	
   }

    @GetMapping("/{customerId}/orders")
    public List<OrderDTO> getOrders(@PathVariable Long customerId) {

        return orderService.getOrdersForCustomerById(customerId);
    }
}