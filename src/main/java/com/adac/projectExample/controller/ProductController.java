package com.adac.projectExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adac.projectExample.model.Product;
import com.adac.projectExample.request.NewProductRequest;
import com.adac.projectExample.request.UpdateStockProductRequest;
import com.adac.projectExample.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/byId/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable String id){
		Product product = productService.getProductById(id);
		return ResponseEntity.ok(product);
	}
	
	@PostMapping
	public ResponseEntity<String> saveProduct(@RequestBody NewProductRequest request){
		String response = productService.saveProduct(request);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/byId/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable String id){
		String response = productService.deleteProduct(id);
		return ResponseEntity.ok(response);
	}
	
	@PatchMapping("/updateStock")
	public ResponseEntity<String> updateQuantityById(@RequestBody UpdateStockProductRequest request){
		String respónse = productService.updateStockById(request.getId(), request.getNewQuantity());
		return ResponseEntity.ok(respónse);
	}
	
}
