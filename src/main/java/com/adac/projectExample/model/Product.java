package com.adac.projectExample.model;

import java.util.UUID;

public class Product {

	private UUID id;
	private String description;
	private Long price;
	private Integer quantity;
	
	public Product() {}
	
	public Product(UUID id, String description, Long price, Integer quantity) {
		this.id = id;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Product(String description, Long price, Integer quantity) {
		this.id = UUID.randomUUID();
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return description + " - $" + price;
	}

}
