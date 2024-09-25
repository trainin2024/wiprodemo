package com.example.demo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.OrderDTO;
@FeignClient(name = "order-service", url = "http://localhost:8000") // Change URL as nee
public interface OrderClient {

    @GetMapping("/order/{id}/orders")
	List<OrderDTO> getOrderByCustomerId(@PathVariable("id") Long customerId);

}
