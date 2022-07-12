package com.matheusbandeira.producerorders.service;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.matheusbandeira.producerorders.kafka.KafkaProducerConfig;
import com.matheusbandeira.producerorders.model.Order;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class OrderService {

	@Autowired
	private KafkaProducerConfig kafkaProducerConfig;

	public HashMap<String, String> create(Order order) throws JsonProcessingException {

		//log.info("New order was received: {}", order);
		System.out.println("New order was received: " + order);
		ObjectMapper objectMapper = new ObjectMapper();

		order.setId(UUID.randomUUID().toString());


		String message = objectMapper.writeValueAsString(order);

		//log.info("Sending new order to topic_shop_client", message);
		System.out.println("Sending new order to topic_shop_client " + message);
		this.kafkaProducerConfig.sendMessage(message);
		
		var response = new HashMap<String, String>();
		response.put("Shop message", "Hello " + order.getClientName() + "! Your order has been sent. Thanks.");
		
		return response;
	}
}
