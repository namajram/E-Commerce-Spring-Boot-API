package com.api.service.impl;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.api.entities.Product;
import com.api.repository.ProductRepository;
import com.api.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product createProduct(Product product, MultipartFile file) throws IOException {
		
		byte[] bytes = file.getBytes();
		String encodeToString = Base64.getEncoder().encodeToString(bytes);
		product.setImages(encodeToString);
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(long productId, Product product, MultipartFile file) throws IOException {
		Product exitProduct = productRepository.findById(productId).get();

		
		byte[] bytes = file.getBytes();
		String encodeToString = Base64.getEncoder().encodeToString(bytes);
		exitProduct.setImages(encodeToString);
		exitProduct.setCreated(product.getCreated());
		exitProduct.setDescription(product.getDescription());
		exitProduct.setPrice(product.getPrice());
		exitProduct.setProductBrand(product.getProductBrand());
		exitProduct.setProductName(product.getProductName());
		exitProduct.setProductQuantity(product.getProductQuantity());
		

		return productRepository.save(exitProduct);

	}

	@Override
	public boolean deleteProduct(long productId) {
		Optional<Product> optional = productRepository.findById(productId);
		if (optional.isPresent()) {
			productRepository.delete(optional.get());
			return true;
		}
		return false;
	}

	@Override
	public Product getProductById(long productId) {
		Product optional = productRepository.findById(productId).get();

		return optional;
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

}


