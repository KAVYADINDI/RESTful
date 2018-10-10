package com.capgemini.orderapp.service;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.orderapp.entity.Orders;

public interface OrderService {

	public Orders addOrder(Orders order);

	public Orders updateOrder(Orders order);

	public void deleteOrder(Orders order);

	public Orders findOrderById(int orderId);

	public List<Orders> findOrderByCustomerID(int customerId);

	public List<Orders> findOrderByDate(LocalDate orderDate);

}
