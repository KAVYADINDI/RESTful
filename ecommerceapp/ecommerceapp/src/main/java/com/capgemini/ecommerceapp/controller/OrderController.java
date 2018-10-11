package com.capgemini.ecommerceapp.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/cart/{customerId}")
	public ResponseEntity<Set<Items>> getCartItems(@PathVariable int customerId) {
		Set<Items> sampleItem = hashMap.get(customerId);
		return new ResponseEntity<Set<Items>>(sampleItem, HttpStatus.OK);
	}

	@DeleteMapping("/cart/{customerId}")
	public ResponseEntity<Set<Items>> deleteCartItems(@PathVariable int customerId, @RequestBody Items item) {
		Set<Items> sampleItem = hashMap.get(customerId);
		if (sampleItem != null) {
			sampleItem.remove(item);
			hashMap.put(customerId, sampleItem);
		}
		return new ResponseEntity<Set<Items>>(sampleItem, HttpStatus.OK);
	}

	@PostMapping("/order")
	public ResponseEntity<Orders> addOrder(@RequestBody Orders order) {
		return new ResponseEntity<Orders>(orderService.submitOrder(order), HttpStatus.OK);
	}

	@PutMapping("/order")
	public ResponseEntity<Orders> updateOrder(@RequestBody Orders order) {
		return new ResponseEntity<Orders>(orderService.updateOrder(order), HttpStatus.OK);
	}

	@PutMapping("/order/{orderId}")
	public ResponseEntity<Orders> cancelOrder(@PathVariable int orderId) {
		return new ResponseEntity<Orders>(orderService.cancelOrder(orderId), HttpStatus.OK);
	}

	@GetMapping("/order/{orderId}")
	public ResponseEntity<Orders> getOrderById(@PathVariable int orderId) {
		return new ResponseEntity<Orders>(orderService.findOrderById(orderId), HttpStatus.OK);
	}

	@DeleteMapping("/order/{orderId}")
	public ResponseEntity<Orders> deleteOrder(@PathVariable int orderId) {
		orderService.deleteOrder(orderId);
		return new ResponseEntity<Orders>(HttpStatus.OK);
	}

	@GetMapping("/orders")
	public ResponseEntity<List<Orders>> getOrders() {
		return  new ResponseEntity<List<Orders>>(orderService.getOrders(), HttpStatus.OK);
	}
}
