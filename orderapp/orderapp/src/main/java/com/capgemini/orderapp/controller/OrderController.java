package com.capgemini.orderapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capgemini.orderapp.entity.Orders;
import com.capgemini.orderapp.service.OrderService;

@Controller
public class OrderController {

	static Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order")
	public ResponseEntity<Orders> addOrder(@RequestBody Orders order) {
		logger.info("Add new order: " + order );
		return new ResponseEntity<Orders>(orderService.addOrder(order), HttpStatus.OK);
	}

//	@GetMapping("/order/{orderId}")
//	public ResponseEntity<Orders> findOrderById(@PathVariable int orderId) {
//		logger.info("Get order by Id: " + orderId);
//		return new ResponseEntity<Orders>(orderService.findOrderById(orderId), HttpStatus.OK);
//	}
}
