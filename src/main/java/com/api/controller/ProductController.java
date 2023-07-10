package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.entities.Product;
import com.api.service.impl.ProductServiceImpl;

@RestController
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@PostMapping("/Product/create")
    public ResponseEntity<?> createProduct( @ModelAttribute  Product product, @RequestParam("image") MultipartFile file)throws Throwable {
		try {   
			Product createdUser = productServiceImpl.createProduct(product,file);
        return ResponseEntity.ok(createdUser);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Error create product");
		}
    }
	
	 @PutMapping("/Product/update/{id}")
	 
	    public ResponseEntity<?> updateProduct(@PathVariable Integer id, @ModelAttribute Product product, @RequestParam("image")MultipartFile file)throws Throwable {
		  try {
			  Product updatedUser = productServiceImpl.updateProduct(id, product,file);
	        if (updatedUser != null) {
	            return ResponseEntity.ok(updatedUser);
	        }
	        return ResponseEntity.notFound().build();
	  } catch (Exception e) {
				return ResponseEntity.internalServerError().body(e);
			}
		    }
	 
	 @DeleteMapping("/Product/delete/{id}")
	  
	    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
		  try {
	        boolean deleted = productServiceImpl.deleteProduct(id);
	        if (deleted) {
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.notFound().build();
		  } catch (Exception e) {
				return ResponseEntity.internalServerError().body(e);
			}
		    }
	  
	  @GetMapping("/Product/get/{id}")
	 
	    public ResponseEntity<?> getProductById(@PathVariable Integer id) {
		  try {
			  Product user = productServiceImpl.getProductById(id);
	        if (user != null) {
	            return ResponseEntity.ok(user);
	        }
	        return ResponseEntity.notFound().build();
		  } catch (Exception e) {
				return ResponseEntity.internalServerError().body(e);
			}
		    }
	  
	  @GetMapping("/Product/get/all")
	  
	    public ResponseEntity<?> getAllProduct() {
		  try {
			  List<Product> users = productServiceImpl.getAllProduct();
		  
	        return ResponseEntity.ok(users);
	  } catch (Exception e) {
			return ResponseEntity.internalServerError().body(e);
		}
	    }
}
