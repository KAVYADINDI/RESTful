package com.capgemini.website.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.website.entity.Orders;

public interface OrderRepository extends MongoRepository<Orders,Integer>{

}
