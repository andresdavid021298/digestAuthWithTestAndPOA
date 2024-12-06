package com.adac.projectExample.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adac.projectExample.converter.CustomerMapper;
import com.adac.projectExample.model.Customer;
import com.adac.projectExample.repository.CustomerRepository;
import com.adac.projectExample.request.NewCustomerRequest;
import com.adac.projectExample.util.MessageUtil;

@Service
public class CustomerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

	private CustomerRepository repository;
	private MessageUtil messageUtil;
	private CustomerMapper customerMapper;

	public List<Customer> getAllCustomers() {
		List<Customer> customers = repository.getAll();
		LOGGER.info("** CUSTOMERS SIZE: {} **", customers.size());
		return customers;
	}
	
	public Customer getCustomerByEmail(String email) {
		List<Customer> customers = repository.getAll();
		Optional<Customer> customerFounded = customers.stream()
				.filter(customer -> customer.getEmail().equalsIgnoreCase(email)).findFirst();
		if(!customerFounded.isPresent()) return null;
		return customerFounded.get();
	}
	
	public String saveCustomer(NewCustomerRequest request) {
		if (getCustomerByEmail(request.getEmail()) == null) {
			Customer customer = customerMapper.NewCustomerRequestToCustomerConvert(request);
			repository.addOrUpdate(customer);
			return messageUtil.getMessage("customer.insert.ok");
		}
		return messageUtil.getMessage("customer.insert.email.repeat");
	}
	
	public String deleteCustomer(String id) {
		Customer customer = repository.getById(id);
		if(customer == null) { return messageUtil.getMessage("customer.delete.not.found"); }
		repository.delete(id);
		return messageUtil.getMessage("customer.delete.ok");
	}

	@Autowired
	public void setRepository(CustomerRepository repository) {
		this.repository = repository;
	}

	@Autowired
	public void setMessageUtil(MessageUtil messageUtil) {
		this.messageUtil = messageUtil;
	}

	@Autowired
	public void setCustomerMapper(CustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
	}

}
