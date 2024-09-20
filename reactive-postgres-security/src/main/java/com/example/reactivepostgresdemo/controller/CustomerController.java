package com.example.reactivepostgresdemo.controller;

import com.example.reactive.postgresdemo.service.UserService;
import com.example.reactive.postgresdemo.util.JwtUtil;
import com.example.reactivepostgresdemo.model.Customer;
import com.example.reactivepostgresdemo.model.LoginRequest;
import com.example.reactivepostgresdemo.model.User;
import com.example.reactivepostgresdemo.repo.CustomerRepository;
import com.example.reactivepostgresdemo.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @GetMapping //http://localhost:9090/customer
    public Flux<Customer> getCustomers(){ //0...N
        return repository.findAll();
    }

    @GetMapping("/{id}") //http://localhost:9090/customer/100
    public Mono<Customer> getCustomer(@PathVariable Integer id){ //0...1
        return repository.findById(id);
    }
    
/*
 * //http://localhost:9090/customer
 * {
	"name" : "Alex400"
	}
 * */
    
    @PostMapping
    // http://localhost:9090/customer
    public Mono<Customer> createCustomer(@RequestBody Customer customer){
       return  repository.save(customer);
    }

//    @PostMapping("/upload")
//    public Mono<Void> uploadFile(@RequestPart("files")Flux<FilePart> filePartFlux){
//         return filePartFlux.flatMap( it -> {
//                    try {
//                       return   it.transferTo(Files.createFile(Paths.get("tmp/"+ it.filename())));
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                });
//
//    }
/*  flatMap() is the combination of a map and a flat operation i.e, it first applies map function and than flattens the result. 
 * [ [2, 3, 5], [7, 11, 13], [17, 19, 23] ]
 * 
 * After Flattening, it gets transformed into “one level” structure as shown :
 * [ 2, 3, 5, 7, 11, 13, 17, 19, 23 ] 
 * ) map() is used for transformation only, but flatMap() is used for both transformation and flattening.
 * 
 * */
    @PutMapping("/{id}")
    public Mono<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Integer id){
        return repository.findById(id)
                        .map((c) -> {
                            c.setName(customer.getName());
                            return c;
                        }).flatMap( c -> repository.save(c));

    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCustomer(@PathVariable Integer id){
    	System.out.println(" DELETE Called");
        return repository.deleteById(id);
    }
    
   
}
