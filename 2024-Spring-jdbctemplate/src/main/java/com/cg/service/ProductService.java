package com.cg.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.cg.exception.InvalidIDException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Product;
import com.cg.repo.ProductDAO;


@Service
public class ProductService  {	
	@Autowired
	ProductDAO productRepo;


	public  List<Product> getProductsFromDatabase() {
		return productRepo.getAllProducts();
	}

	
	public Product getProductById(int id) throws ResourceNotFoundException {
		Product updatedProduct = productRepo.findbyId(id)
				.orElseThrow(()-> new ResourceNotFoundException("Product is not available:"+ id));
		return updatedProduct;
	}	
	
	
	 public int  createProduct(  Product product) throws InvalidIDException {
		 if(product.getId()==0)
		 {
			 throw new InvalidIDException("Id cannot be null");
		 }
		 else
			 return productRepo.saveProduct(product);
	    
	}

	/*@Override
	public ResponseEntity<Product> updateProduct(Product changedPoduct)
			throws ResourceNotFoundException {
		 System.out.println(" I am in service");
		 Product product = productRepo.findbyId(changedPoduct.getId())
				
		
		product.setPname(changedPoduct.getPname());
		product.setPrice(changedPoduct.getPrice());
		productRepo.updateProduct(product); //call to dao
	
			return ResponseEntity.ok(product);
		}
	*/

	/*
	 * Find a product - if it is null throw and exception
	 * 
	 * */
	 public Product updateProduct( @RequestBody Product newproduct)
			throws ResourceNotFoundException {
		Product updatedProduct = productRepo.findbyId(newproduct.getId())
							.orElseThrow(()-> new ResourceNotFoundException("Product is not avaialble:"+ newproduct.getId()));
		updatedProduct.setPname(newproduct.getPname());
		updatedProduct.setPrice(newproduct.getPrice());
		productRepo.updateProduct(updatedProduct);
	
		return updatedProduct;
	}
	

	
	public Map<String, Boolean> deleteProduct(Integer productId) throws ResourceNotFoundException {
		System.out.println();
		Product product = productRepo.findbyId(productId)
		.orElseThrow(()-> new ResourceNotFoundException("Cannot delete product which is not exisitng"+ productId));
	
			productRepo.deleteProduct(product.getId());
	
		Map<String,Boolean> response  = new HashMap<>();
		response.put("Product has been Deleted", Boolean.TRUE);
		return response;
	}
}
