package com.adac.projectExample.repository;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.adac.projectExample.model.Customer;

@SpringJUnitConfig(classes = CustomerRepository.class )
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerRepositoryTest {

	private static final String UUID_CUSTOMER_FOR_TEST = "fe9341a-54d7-427b-8ec6-5e7526a3fad5";
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	@Order(1)
	void testAddOrUpdate() {
		Customer customerMock = Mockito.mock(Customer.class);
		Mockito.when(customerMock.getId()).thenReturn(UUID.fromString(UUID_CUSTOMER_FOR_TEST));
		Mockito.when(customerMock.getName()).thenReturn("German Garcia");
		Mockito.when(customerMock.getEmail()).thenReturn("gergarcia@mail.com");
		customerRepository.addOrUpdate(customerMock);
	}
	
	@Test
	@Order(2)
	void testGetById() {
		Customer customer = customerRepository.getById(UUID_CUSTOMER_FOR_TEST);
		Assertions.assertAll(
				()->{ Assertions.assertNotNull(customer); }, 
				()->{ Assertions.assertEquals("gergarcia@mail.com",customer.getEmail()); }
			);
	}

	@Test
	@Order(3)
	void testGetAll() {
		List<Customer> customers = customerRepository.getAll();
		Assertions.assertEquals( 5, customers.size());
	}

	@Test
	@Order(4)
	void testDelete() {
		customerRepository.delete(UUID_CUSTOMER_FOR_TEST);
		List<Customer> customerAfterDelete = customerRepository.getAll();
		Assertions.assertEquals(4, customerAfterDelete.size());
	}

}
