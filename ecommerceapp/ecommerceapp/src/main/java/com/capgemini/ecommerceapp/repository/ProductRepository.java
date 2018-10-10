package com.capgemini.ecommerceapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.ecommerceapp.entity.Product;

public interface ProductRepository extends MongoRepository<Product, Integer>{

}
