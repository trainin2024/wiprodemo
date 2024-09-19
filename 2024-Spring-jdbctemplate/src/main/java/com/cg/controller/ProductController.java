package com.cg.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.cg.repo.ProductDAO;
import com.cg.exception.InvalidIDException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Product;
import com.cg.service.ProductService;
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class ProductController {

	@Autowired
	ProductService service;
	 /*
	  * The @ResponseBody annotation tells a controller that the object
	  *  returned is automatically serialized into JSON and passed back 
	  *  into the HttpResponse object. 
	  *  When you use the @ResponseBody annotation on a method,
	  *   Spring converts the return value and writes it to the HTTP
	  *    response automatically. 
	  * Each method in the Controller class must be annotated with @ResponseBody.
	  * */
	@GetMapping("/products")
	@ResponseBody
	public ResponseEntity<List<com.cg.model.Product>>findall()
	{ 
	  List<Product> productlist = service.getProductsFromDatabase();
	  System.out.println(productlist);
		return (ResponseEntity<List<Product>>) new ResponseEntity<List<Product>>(productlist, HttpStatus.OK);
	}
	
	@GetMapping("/products/{id}")
	@ResponseBody
	public ResponseEntity<Product> findByid(@PathVariable (value="id")  Integer productId) throws ResourceNotFoundException 
	{
		Product product = service.getProductById(productId);
		 return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	 //ResponseEntity represents the whole HTTP response: status code, headers, and body.
	//ResponseEntity is a simple wrapper of HTTP response object;
	 @PutMapping("/products")
	 public ResponseEntity<Product> updateProduct(@RequestBody Product newProduct) 
			 throws ResourceNotFoundException{
		 System.out.println(" I am in controller");
		 Product product = service.updateProduct( newProduct);
				return new ResponseEntity<Product>(product, HttpStatus.OK);
	 }

	 /* @DeleteMapping("/products/{id}")	
	  public Map<String,Boolean> deleteProduct(@PathVariable (value="id") Integer productId) throws ResourceNotFoundException
	   {
	    	return service.deleteProduct(productId);
	   }*/
	 /*
	  * The @ResponseBody annotation tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object. When you use the @ResponseBody annotation on a method, Spring converts the return value and writes it to the HTTP response automatically. 
	  * Each method in the Controller class must be annotated with @ResponseBody.
	  * */
	 @DeleteMapping("/products/{id}")
	    @ResponseBody
	    public ResponseEntity<String> deleteProduct(@PathVariable int id) throws ResourceNotFoundException{
	        service.deleteProduct(id);
	        return new ResponseEntity<String>("Product Deleted",HttpStatus.ACCEPTED);
	    }
	  
	  @PostMapping("/products")
	  @ResponseBody
	    public ResponseEntity<Integer> createProduct( @RequestBody Product newProduct) throws InvalidIDException {
	        return new ResponseEntity<Integer>(service.createProduct(newProduct), HttpStatus.CREATED);
	    }
}
