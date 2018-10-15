package com.capgemini.website.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.website.entity.Items;
import com.capgemini.website.entity.Product;
import com.capgemini.website.service.ProductService;
@RefreshScope
@RestController
public class OrderController {

	private List<Items> cartItems;
	@Autowired
	private ProductService productService;

	public OrderController() {
		cartItems = new ArrayList<>();
	}

	@RequestMapping("/")
	public String homePage() {
		return "products";
	}
	
	@RequestMapping(path = "/addtocart")
	public String addToCart(HttpServletRequest request, Model model,@RequestParam int productId) {
		HttpSession session = request.getSession();
		boolean flag = false;
		double total = 0;
		
		Product product = productService.findProductById(productId);
		
		for (Items i : cartItems) {
			if (i.getProduct().getProductId() == productId) {
				i.setProductQuantity(i.getProductQuantity()+1);
				System.out.println(i.getProductQuantity());
				flag = true;
			}
		}
		if (!flag) {
			Items item = new Items(product,1,product.getProductPrice());
			cartItems.add(item);
		}
	
		for (Items i : cartItems) {
			total = total + i.getItemAmount()*i.getProductQuantity();
		}
		session.setAttribute("totalAmount", total);
		session.setAttribute("cart", cartItems);
		return "products";
	}
	
	@RequestMapping("/cart")
	public String cart(HttpServletRequest request, Model model) {
		return "cart";
	}
}
