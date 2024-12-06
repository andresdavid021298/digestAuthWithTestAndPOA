package com.adac.projectExample.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.adac.projectExample.model.Product;

import jakarta.annotation.PostConstruct;

@Repository
public class ProductRepository implements BaseRepository<Product> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductRepository.class);

	private Map<UUID, Product> productCache = new HashMap<>();

	@PostConstruct
	private void init() {
		Product price1 = new Product("Bolsa Sal", 2700L, 5);
		Product price2 = new Product("Paquete Galletas 24gr", 6990L, 12);
		Product price3 = new Product("Harina Maiz Blanco 1000gr", 3500L, 20);
		Product price4 = new Product("Aceite Vegetal", 23000L, 3);
		Product price5 = new Product("Papel Higienico 12 rollos", 17800L, 8);
		productCache.put(price1.getId(), price1);
		productCache.put(price2.getId(), price2);
		productCache.put(price3.getId(), price3);
		productCache.put(price4.getId(), price4);
		productCache.put(price5.getId(), price5);
		LOGGER.info("** PRODUCT CACHE LOADED **");
	}

	@Override
	public Product getById(String id) {
		return productCache.get(UUID.fromString(id));
	}

	@Override
	public List<Product> getAll() {
		List<Product> allProducts = new ArrayList<Product>(productCache.values());
		return allProducts;
	}

	@Override
	public void addOrUpdate(Product product) {
		if(product.getId() == null) product.setId(UUID.randomUUID()); 
		productCache.put(product.getId(), product);
	}

	@Override
	public void delete(String id) {
		productCache.remove(UUID.fromString(id));
	}
	
}
