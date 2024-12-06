package com.adac.projectExample.util;

public enum MethodPaymentEnum {

	CREDIT_CARD(1, "Credit Card"), 
	DEBIT_CARD(2, "Debit Card"), 
	CASH(3, "Cash");

	private Integer idMethodPayment;
	private String nameMethodPayment;

	private MethodPaymentEnum(Integer idMethodPayment, String nameMethodPayment) {
		this.idMethodPayment = idMethodPayment;
		this.nameMethodPayment = nameMethodPayment;
	}

	public Integer getIdMethodPayment() {
		return idMethodPayment;
	}

	public String getNameMethodPayment() {
		return nameMethodPayment;
	}

	public static MethodPaymentEnum getMethodPaymentById(Integer id) {
		for(MethodPaymentEnum method : MethodPaymentEnum.values()) {
			if(method.getIdMethodPayment().equals(id)) return method;
		}
		return null;
	}
	
}
