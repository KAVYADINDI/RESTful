package com.capgemini.website.entity;


public class Items {
	private Product product;
	private int productQuantity;
	private int itemAmount;
	

	
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
	public int getItemAmount() {
		return itemAmount;
	}
	public void setItemAmount(int itemAmount) {
		this.itemAmount = itemAmount;
	}
	public Items(Product product, int productQuantity, int itemAmount) {
		super();
		this.product = product;
		this.productQuantity = productQuantity;
		this.itemAmount = itemAmount;
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
