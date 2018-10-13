package com.capgemini.website.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.website.entity.Product;



public interface ProductRepository extends MongoRepository<Product,Integer> {

}
