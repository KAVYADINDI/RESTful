package com.capgemini.orderapp.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.orderapp.entity.Orders;
import com.capgemini.orderapp.repository.OrderRepository;
import com.capgemini.orderapp.service.OrderService;
import com.capgemini.orderapp.service.exceptions.OrderExistsException;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public Orders addOrder(Orders order) {
		Optional<Orders> orderFromDb = orderRepository.findById(order.getOrderId());
		if (!orderFromDb.isPresent()) {
			return orderRepository.save(order);
		}
		throw new OrderExistsException("Order with id " +order.getOrderId()+" already exists");
	}

	@Override
	public Orders updateOrder(Orders order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(Orders order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Orders findOrderById(int orderId) {
		Optional<Orders> orderFromDb = orderRepository.findById(orderId);
		if (orderFromDb.isPresent()) {
			return orderFromDb.get();
		}
		throw new OrderDoesnotExistsException("Order with id " +orderId+" does not exist");
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

}
