package com.capgemini.ecommerceapp.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ecommerceapp.entity.Items;
import com.capgemini.ecommerceapp.entity.Orders;
import com.capgemini.ecommerceapp.repository.OrderRepository;
import com.capgemini.ecommerceapp.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Override
	public Orders submitOrder(Orders order) {
		order.setStatus("OrderPlaced");
		Set<Items> cartItems = order.getItems();
		double totalPrice = 0;
		for (Items item : cartItems) {
			totalPrice += item.getItemAmount();
		}
		order.setOrderTotalAmount(totalPrice);
		order.setOrderDate(LocalDate.now());
		return orderRepository.save(order);
	}

	@Override
	public Orders updateOrder(Orders order) {
		Optional<Orders> optional = orderRepository.findById(order.getOrderId());
		if (optional.isPresent()) {
			order.setStatus("OrderUpadted");
			return orderRepository.save(order);
		}
		return null;
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
	public Orders cancelOrder(int orderId) {
		Optional<Orders> optional = orderRepository.findById(orderId);
		if (optional.isPresent()) {
			optional.get().setStatus("cancelled");
			return orderRepository.save(optional.get());
		}
		return null;
	}
	
	@Override
	public void deleteOrder(int orderId) {
		 orderRepository.deleteById(orderId);
	}
	
	@Override
	public List<Orders> getOrders() {	
	return	orderRepository.findAll();
	}
	
	@Override
	public List<Orders> findOrderByCustomerId(int customerId) {
		return orderRepository.findOrderByCustomerId(customerId);
	}

	@Override
	public List<Orders> findOrderByDate(LocalDate orderDate) {
		// TODO Auto-generated method stub
		return null;
	}
}
