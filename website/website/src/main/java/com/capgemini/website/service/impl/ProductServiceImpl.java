package com.capgemini.website.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.website.entity.Product;
import com.capgemini.website.repository.ProductRepository;
import com.capgemini.website.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	
	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product findProductById(int productId) {
		Optional<Product> optionalProduct = productRepository.findById(productId);
			return optionalProduct.get();
	}

	@Override
	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}
}
