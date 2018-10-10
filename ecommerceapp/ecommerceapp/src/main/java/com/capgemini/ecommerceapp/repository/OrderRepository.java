package com.capgemini.ecommerceapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.ecommerceapp.entity.Orders;

public interface OrderRepository extends MongoRepository<Orders,Integer>{

}
