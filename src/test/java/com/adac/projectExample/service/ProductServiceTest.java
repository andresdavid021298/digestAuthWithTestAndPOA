package com.adac.projectExample.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.adac.projectExample.ProjectExampleApplication;
import com.adac.projectExample.model.Product;
import com.adac.projectExample.request.NewProductRequest;

@SpringJUnitConfig(classes = { ProductService.class, ProjectExampleApplication.class })
@TestPropertySource("classpath:application-test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductServiceTest {

	@Autowired
	private ProductService productService;
	
	@Test
	@Order(1)
	void testGetAllProducts() {
		List<Product> products = productService.getAllProducts();
		Assertions.assertEquals(5, products.size());
	}

	@Test
	@Order(2)
	void testSaveProduct() {
		NewProductRequest newProductRequest = Mockito.mock(NewProductRequest.class);
		String response = productService.saveProduct(newProductRequest);
		Assertions.assertAll(
				()->{ Assertions.assertTrue(response.contains("added")); },
				()->{ Assertions.assertEquals(6, productService.getAllProducts().size()); }	
		);
	}
	
	@Test
	@Order(3)
	void testGetProductById() {
		String idProductForSearch = productService.getAllProducts().stream().findAny().get().getId().toString();
		Product product = productService.getProductById(idProductForSearch);
		Assertions.assertNotNull(product);
	}

	@Test
	@Order(4)
	void testUpdateStockById() {
		String idProductForSearch = productService.getAllProducts().stream().findAny().get().getId().toString();
		String response = productService.updateStockById(idProductForSearch, 15);
		Assertions.assertTrue(response.contains("Updated"));
	}
	
	@Test
	@Order(5)
	void testUpdateStockByIdProductNotFound() {
		String idProductNotExist = "25812888-ddb3-43bb-85cf-860369f42bfd";
		String response = productService.updateStockById(idProductNotExist, 15);
		Assertions.assertTrue(response.contains("not found"));
	}
	
	@Test
	@Order(6)
	void testDeleteProduct() {
		String idProductForSearch = productService.getAllProducts().stream().findAny().get().getId().toString();
		String response = productService.deleteProduct(idProductForSearch);
		Assertions.assertTrue(response.contains("deleted"));
	}

}
