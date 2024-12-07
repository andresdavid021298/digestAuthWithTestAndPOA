package com.adac.projectExample.repository;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.adac.projectExample.model.Product;

@SpringJUnitConfig(classes = ProductRepository.class )
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductRepositoryTest {

	private static final String UUID_PRODUCT_FOR_TEST = "2e9af5ad-b752-47a0-8c6e-99d1283a8751";
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	@Order(1)
	@DisplayName("testUpdate")
	void testAddWithUUID() {
		Product productMock = Mockito.mock(Product.class);
		Mockito.when(productMock.getId()).thenReturn(UUID.fromString(UUID_PRODUCT_FOR_TEST));
		Mockito.when(productMock.getPrice()).thenReturn(15500L);
		Mockito.when(productMock.getQuantity()).thenReturn(12);
		Mockito.when(productMock.getDescription()).thenReturn("Pringles Sabor Original");
		productRepository.addOrUpdate(productMock);
	}
	
	@Test
	@Order(1)
	@DisplayName("testSave")
	void testAddWithoutUUID() {
		Product productMock = Mockito.mock(Product.class);
		Mockito.when(productMock.getPrice()).thenReturn(9900L);
		Mockito.when(productMock.getQuantity()).thenReturn(21);
		Mockito.when(productMock.getDescription()).thenReturn("Juguete HotWheels");
		productRepository.addOrUpdate(productMock);
	}
	
	@Test
	@Order(2)
	void testGetById() {
		Product product = productRepository.getById(UUID_PRODUCT_FOR_TEST);
		Assertions.assertAll(
				()->{ Assertions.assertNotNull(product); }, 
				()->{ Assertions.assertEquals(12,product.getQuantity()); }
			);
	}

	@Test
	@Order(3)
	void testGetAll() {
		List<Product> products = productRepository.getAll();
		Assertions.assertEquals( 7, products.size());
	}

	@Test
	@Order(4)
	void testDelete() {
		productRepository.delete(UUID_PRODUCT_FOR_TEST);
		List<Product> productAfterDelete = productRepository.getAll();
		Assertions.assertEquals(6, productAfterDelete.size());
	}

}
