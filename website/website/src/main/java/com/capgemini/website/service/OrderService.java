package com.capgemini.website.service;

import java.util.List;

import com.capgemini.website.entity.Orders;



public interface OrderService {

	public Orders submitOrder(Orders order);

	public Orders updateOrder(Orders order);
	
	public void deleteOrder(int orderId);

	public Orders findOrderById(int orderId);

	public Orders cancelOrder(int orderId);

	public List<Orders> getOrders();
	
}
