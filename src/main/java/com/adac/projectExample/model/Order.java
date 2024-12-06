package com.adac.projectExample.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.adac.projectExample.util.MethodPaymentEnum;

public class Order {

	private UUID id;
	private Customer customer;
	private List<Product> products;
	private Long finalPrice;
	private LocalDate purchaseDate;
	private MethodPaymentEnum methodPayment;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Long getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Long finalPrice) {
		this.finalPrice = finalPrice;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public MethodPaymentEnum getMethodPayment() {
		return methodPayment;
	}

	public void setMethodPayment(MethodPaymentEnum methodPayment) {
		this.methodPayment = methodPayment;
	}

}
