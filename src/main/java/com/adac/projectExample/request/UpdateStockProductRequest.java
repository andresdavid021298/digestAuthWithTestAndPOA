package com.adac.projectExample.request;

public class UpdateStockProductRequest {

	private String id;
	private Integer newQuantity;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNewQuantity() {
		return newQuantity;
	}

	public void setNewQuantity(Integer newQuantity) {
		this.newQuantity = newQuantity;
	}

	@Override
	public String toString() {
		return id + " - Quantity:" + newQuantity;
	}
	
}
