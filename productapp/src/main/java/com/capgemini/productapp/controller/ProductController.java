package com.capgemini.productapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capgemini.productapp.entity.Product;
import com.capgemini.productapp.service.ProductService;

public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		logger.info("Added new product :" + product);
		return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.OK);
	}

	@PutMapping("/product")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		productService.findProductById(product.getProductId());
		logger.info("Updated product with Id :" + product.getProductId() + " to : " + product);
		return new ResponseEntity<Product>(productService.updateProduct(product), HttpStatus.OK);
	}

	@GetMapping("/product/{productId}")
	public ResponseEntity<Product> findProductById(@PathVariable int productId) {
		logger.info("ID of Product to be found : " + productId);
		return new ResponseEntity<Product>(productService.findProductById(productId), HttpStatus.OK);
	}

	@DeleteMapping("/product/{productId}")
	public ResponseEntity<Product> deleteProduct(@PathVariable int productId) {

			productService.deleteProduct(productService.findProductById(productId));
			logger.info("Deleted product by id: " + productId);
			return new ResponseEntity<Product>(HttpStatus.OK);
	}
}
