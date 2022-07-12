package com.matheusbandeira.producerorders.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class KafkaProducerConfig {

	@Value("${topic.shop-client}")
	private String topicShopClient;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {

		// envia mensagem para topico criado
		this.kafkaTemplate.send(topicShopClient, message);
		System.out.println("Sending message to topic_shop_client: " + message);
		//log.info("Sending message to topic_shop_client: {}", message);
		
	}
}
