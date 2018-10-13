package com.capgemini.website.service;

import com.capgemini.website.entity.Product;

public interface ProductService {

	public Product addProduct(Product product);

	public Product updateProduct(Product product);

	public Product findProductById(int productId) ;

	public void deleteProduct(Product product);
}
