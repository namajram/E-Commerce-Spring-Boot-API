package com.api.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.api.entities.Product;

public interface ProductService {

	List<Product> getAllProduct();

	Product getProductById(long productId);

	boolean deleteProduct(long productId);

	Product createProduct(Product product, MultipartFile file) throws IOException;

	Product updateProduct(long productId, Product product, MultipartFile file) throws IOException;

}
