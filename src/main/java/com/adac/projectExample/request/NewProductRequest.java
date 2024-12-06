package com.adac.projectExample.request;

public class NewProductRequest {

	private String description;
	private Long price;
	private Integer quantity;

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
		return description + " - $" + price + " - " + quantity;
	}
	
}
