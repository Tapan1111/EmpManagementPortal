package com.work.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.work.common.ApiResponse;
import com.work.model.Product;
import com.work.productDto.ProductDto;
import com.work.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/add")
	public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto) {

		productService.createProduct(productDto);
		return new ResponseEntity<>(new ApiResponse(true, "product added successfully"), HttpStatus.CREATED);
	}

	@GetMapping("/getProducts")
	public ResponseEntity<List<ProductDto>> getProducts() {
		List<ProductDto> product = productService.getProducts();
		return new ResponseEntity<List<ProductDto>>(product, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<Product> editProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
		Product updatedProduct = productService.editProduct(id, product);
		return ResponseEntity.ok(updatedProduct);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		productService.deleteUser(id);
	}

}
