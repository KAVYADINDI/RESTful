package com.capgemini.ecommerceapp.entity;

public class Items {
	private Product product;
	private int productQuantity;
	private int itemTotalAmount;
	

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
	public int getItemTotalAmount() {
		return itemTotalAmount;
	}
	public void setItemTotalAmount(int itemTotalAmount) {
		this.itemTotalAmount = itemTotalAmount;
	}
	public Items(Product product, int productQuantity, int itemTotalAmount) {
		super();
		this.product = product;
		this.productQuantity = productQuantity;
		this.itemTotalAmount = itemTotalAmount;
	}
	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void increaseProductQuantity()
	{
		this.productQuantity++;
	}
	public void decreaseProductQuantity()
	{
		this.productQuantity--;
	}
}
