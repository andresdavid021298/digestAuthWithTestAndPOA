package com.adac.projectExample.model;

import java.time.LocalDate;
import java.util.UUID;

public class Customer {

	private UUID id;
	private String name;
	private String address;
	private LocalDate birthDate;
	private String cellphone;
	private String email;

	public Customer() {}
	
	public Customer(UUID id, String name, String address, String cellphone, String email, LocalDate birthdate) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.cellphone = cellphone;
		this.birthDate = birthdate;
	}
	
	public Customer(String name, String address, String cellphone, String email, LocalDate birthdate) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.address = address;
		this.email = email;
		this.cellphone = cellphone;
		this.birthDate = birthdate;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
