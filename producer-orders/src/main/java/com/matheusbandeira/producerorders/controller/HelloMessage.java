package com.matheusbandeira.producerorders.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusbandeira.producerorders.kafka.KafkaProducerConfig;

@RestController
@RequestMapping("/hello")
public class HelloMessage {

	@Autowired
	private KafkaProducerConfig kafkaProducerConfig;
	
	@GetMapping
	public ResponseEntity<HashMap<String, String>> getHello() {
		
		var message = new HashMap<String, String>();
		message.put("message", "Message sent! check kafdrop please.");
		
		this.kafkaProducerConfig.sendMessage("Hello222222 World!");
		
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
