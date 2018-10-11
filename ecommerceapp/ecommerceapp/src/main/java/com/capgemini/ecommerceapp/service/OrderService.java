package com.capgemini.ecommerceapp.service;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.ecommerceapp.entity.Orders;

public interface OrderService {

	public Orders submitOrder(Orders order);

	public Orders updateOrder(Orders order);

//	public Orders deleteOrder(int orderId);
	
	public void deleteOrder(int orderId);

	public Orders findOrderById(int orderId);

	public Orders cancelOrder(int orderId);

	public List<Orders> findOrderByCustomerId(int customerId);

	public List<Orders> findOrderByDate(LocalDate orderDate);

	public List<Orders> getOrders();
	
}
