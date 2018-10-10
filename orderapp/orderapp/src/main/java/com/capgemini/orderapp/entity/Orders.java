package com.capgemini.orderapp.entity;

import java.time.LocalDate;
import java.util.List;

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

	private List<Items> items;

	public Orders() {
		super();
	}

	public Orders(int orderId, double orderTotalAmount, LocalDate orderDate, int customerId, List<Items> items) {
		super();
		this.orderId = orderId;
		this.orderTotalAmount = orderTotalAmount;
		this.orderDate = orderDate;
		this.customerId = customerId;
		this.items = items;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

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

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderTotalAmount=" + orderTotalAmount + ", orderDate=" + orderDate
				+ ", customerId=" + customerId + ", items=" + items + "]";
	}

}
