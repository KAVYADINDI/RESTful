package com.capgemini.website.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.website.entity.Orders;
import com.capgemini.website.repository.OrderRepository;
import com.capgemini.website.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Override
	public Orders submitOrder(Orders order) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
