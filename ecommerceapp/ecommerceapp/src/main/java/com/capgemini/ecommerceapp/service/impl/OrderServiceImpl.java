package com.capgemini.ecommerceapp.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ecommerceapp.entity.Orders;
import com.capgemini.ecommerceapp.repository.OrderRepository;
import com.capgemini.ecommerceapp.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Override
	public Orders submitOrder(Orders order) {
		return orderRepository.save(order);
	}

	@Override
	public Orders updateOrder(Orders order) {
		return orderRepository.save(order);
	}


	@Override
	public Orders findOrderById(int orderId) {
		Optional<Orders> orderFromDb = orderRepository.findById(orderId);
		if (orderFromDb.isPresent()) {
			return orderFromDb.get();
		}
		return null;
	}

	@Override
	public List<Orders> findOrderByCustomerID(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> findOrderByDate(LocalDate orderDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(int orderId) {
		orderRepository.deleteById(orderId);
	}
}
