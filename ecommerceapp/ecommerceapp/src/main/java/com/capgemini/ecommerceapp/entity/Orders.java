package com.capgemini.ecommerceapp.entity;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "Orders")
public class Orders {
	
	
	@Id
	private int orderId;
	private double orderTotalAmount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate orderDate;
	private int customerId;
	private Set<Items> items;
	private String status;
	private static int value=1000;
	public Orders() {
		super();
		orderId = value++;
	}
	public Orders(double orderTotalAmount, LocalDate orderDate, int customerId, Set<Items> items,
			String status) {
		this();
		this.orderTotalAmount = orderTotalAmount;
		this.orderDate = orderDate;
		this.customerId = customerId;
		this.items = items;
		this.setStatus(status);
	}
	public int getOrderId() {
		return orderId;
	}
//	public void setOrderId(int orderId) {
//		this.orderId = orderId;
//	}
	public double getOrderTotalAmount() {
		return orderTotalAmount;
	}
	public void setOrderTotalAmount(double orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Set<Items> getItems() {
		return items;
	}
	public void setItems(Set<Items> items) {
		this.items = items;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public static int getValue() {
		return value;
	}
	public static void setValue(int value) {
		Orders.value = value;
	}
		
}
