package com.capgemini.website.entity;


public class Items {
	private Product product;
	private int productQuantity;
	private double itemAmount;
	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Items(Product product, int productQuantity, double itemAmount) {
		super();
		this.product = product;
		this.productQuantity = productQuantity;
		this.itemAmount = itemAmount;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getItemAmount() {
		return itemAmount;
	}
	public void setItemAmount(double itemAmount) {
		this.itemAmount = itemAmount;
	}
	@Override
	public String toString() {
		return "Items [product=" + product + ", productQuantity=" + productQuantity + ", itemAmount=" + itemAmount
				+ "]";
	}
}
