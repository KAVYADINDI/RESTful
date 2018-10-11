package com.capgemini.ecommerceapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.capgemini.ecommerceapp.entity.Orders;

public interface OrderRepository extends MongoRepository<Orders,Integer>{

	@Query("{'customerId': ?0}")
	public List<Orders> findOrderByCustomerId(int customerId);
}
