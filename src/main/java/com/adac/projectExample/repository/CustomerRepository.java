package com.adac.projectExample.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.adac.projectExample.model.Customer;

import jakarta.annotation.PostConstruct;

@Repository
public class CustomerRepository implements BaseRepository<Customer> {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRepository.class);
	
	private Map<UUID, Customer> customerCache = new HashMap<>();

	@PostConstruct
	private void init() {
		Customer customer1 = new Customer("Andres Ariza", "Calle 1 Niza", "3002588585", "andres@mail.com", LocalDate.of(1998, 12, 2));
		Customer customer2 = new Customer("Diana Ortega", "Avenida 2A Santa Helena", "3011478569", "diana@mail.com", LocalDate.of(2000, 8, 4));
		Customer customer3 = new Customer("Luis Perez", "Calle 12 Salado", "3001231233", "luis@mail.com", LocalDate.of(1987, 2, 21));
		Customer customer4 = new Customer("Carlos Reyes", "Av 3 Cll 1 Prados", "3145455566", "carlosre@mail.com", LocalDate.of(1990, 7, 15));
		customerCache.put(customer1.getId(), customer1);
		customerCache.put(customer2.getId(), customer2);
		customerCache.put(customer3.getId(), customer3);
		customerCache.put(customer4.getId(), customer4);
		LOGGER.info("** CUSTOMER CACHE LOADED **");
	}
	
	@Override
	public Customer getById(String id) {
		return customerCache.get(UUID.fromString(id));
	}

	@Override
	public List<Customer> getAll() {
		List<Customer> allCustomers = new ArrayList<Customer>(customerCache.values());
		return allCustomers;
	}
	
	@Override
	public void delete(String id) {
		customerCache.remove(UUID.fromString(id));
	}

	@Override
	public void addOrUpdate(Customer newCustomer) {
		if(newCustomer.getId() == null) newCustomer.setId(UUID.randomUUID()); 
		customerCache.put(newCustomer.getId(), newCustomer);
	}

}
