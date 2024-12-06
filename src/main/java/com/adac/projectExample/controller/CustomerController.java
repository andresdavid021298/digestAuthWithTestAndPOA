package com.adac.projectExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adac.projectExample.model.Customer;
import com.adac.projectExample.request.NewCustomerRequest;
import com.adac.projectExample.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customers = customerService.getAllCustomers();
		return ResponseEntity.ok(customers);
	}
	
	@GetMapping("/byEmail")
	public ResponseEntity<Customer> getCustomerByEmail(@RequestParam String email){
		Customer customer = customerService.getCustomerByEmail(email);
		return ResponseEntity.ok(customer);
	}
	
	@PostMapping
	public ResponseEntity<String> saveNewCustomer(@RequestBody NewCustomerRequest request){
		String message = customerService.saveCustomer(request);
		return ResponseEntity.ok(message);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable String id){
		String message = customerService.deleteCustomer(id);
		return ResponseEntity.ok(message);
	}
	
}
