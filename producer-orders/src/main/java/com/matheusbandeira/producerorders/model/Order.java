package com.matheusbandeira.producerorders.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Order {

	private String id;
	private String clientName;
	private String clientCPF;
	private Integer productId;
	private Integer quantity;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientCPF() {
		return clientCPF;
	}
	public void setClientCPF(String clientCPF) {
		this.clientCPF = clientCPF;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
