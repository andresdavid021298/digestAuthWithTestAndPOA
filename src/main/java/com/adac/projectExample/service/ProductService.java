package com.adac.projectExample.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adac.projectExample.converter.ProductMapper;
import com.adac.projectExample.model.Product;
import com.adac.projectExample.repository.ProductRepository;
import com.adac.projectExample.request.NewProductRequest;
import com.adac.projectExample.util.MessageUtil;

@Service
public class ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

	private ProductRepository repository;
	private MessageUtil messageUtil;
	private ProductMapper productMapper;

	public List<Product> getAllProducts() {
		List<Product> products = repository.getAll();
		LOGGER.info("** PRODUCTS SIZE: {} **", products.size());
		return products;
	}
	
	public Product getProductById(String id) {
		Product product = repository.getById(id);
		return product;
	}

	public String saveProduct(NewProductRequest request) {
		Product newProduct = productMapper.newProductRequestToProductConvert(request);
		repository.addOrUpdate(newProduct);
		return messageUtil.getMessage("product.insert.ok");
	}

	public String deleteProduct(String id) {
		Product productForDelete = repository.getById(id);
		if (productForDelete == null) { return messageUtil.getMessage("product.delete.not.found"); }
		repository.delete(id);
		return messageUtil.getMessage("product.delete.ok");
	}
	
	public String updateStockById(String id, Integer newQuantity) {
		Product product = repository.getById(id);
		if (product == null) { return messageUtil.getMessage("product.delete.not.found"); }
		LOGGER.info("** UPDATE STOCK PRODUCT {} **", id);
		product.setQuantity(newQuantity);
		repository.addOrUpdate(product);
		return messageUtil.getMessage("product.update.stock");
	}

	@Autowired
	public void setRepository(ProductRepository repository) {
		this.repository = repository;
	}

	@Autowired
	public void setProductMapper(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}

	@Autowired
	public void setMessageUtil(MessageUtil messageUtil) {
		this.messageUtil = messageUtil;
	}

}
