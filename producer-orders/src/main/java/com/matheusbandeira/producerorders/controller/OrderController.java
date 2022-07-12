package com.matheusbandeira.producerorders.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.matheusbandeira.producerorders.model.Order;
import com.matheusbandeira.producerorders.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<HashMap<String, String>> saveOrder(@RequestBody Order order) throws JsonProcessingException {
		return new ResponseEntity<>(this.orderService.create(order), HttpStatus.CREATED);
	}
}
