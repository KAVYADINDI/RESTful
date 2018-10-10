package com.capgemini.ecommerceapp.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ecommerceapp.entity.Items;
import com.capgemini.ecommerceapp.entity.Orders;
import com.capgemini.ecommerceapp.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	private static HashMap<Integer, Set<Items>> hashMap;

	public OrderController() {
		hashMap = new HashMap<>();
	}

	@PostMapping("/order/addToCart")
	public ResponseEntity<Set<Items>> addToCart(@RequestParam int customerId, @RequestBody Items item) {
		Set<Items> listOfItems = hashMap.get(customerId);

		if (listOfItems == null) {
			listOfItems = new HashSet<>();
			listOfItems.add(item);
			hashMap.put(customerId, listOfItems);
		} else {
			if (listOfItems.contains(item))
				item.increaseProductQuantity();
			else {
				listOfItems.add(item);
				hashMap.put(customerId, listOfItems);
			}
		}
		System.out.println(hashMap);
		return new ResponseEntity<Set<Items>>(HttpStatus.OK);
	}

	@PostMapping("/order/placeorder")
	public ResponseEntity<Orders> addOrder(@RequestBody Orders order) {
		System.out.println(order);
		return new ResponseEntity<Orders>(orderService.submitOrder(order), HttpStatus.OK);
	}

	@DeleteMapping("/order/deleteorder/{orderId}")
	public ResponseEntity<Orders> deleteOrder(@PathVariable int orderId)
	{
		orderService.deleteOrder(orderId);
		return new ResponseEntity<Orders>(HttpStatus.OK);
	}
	
	
	
}
