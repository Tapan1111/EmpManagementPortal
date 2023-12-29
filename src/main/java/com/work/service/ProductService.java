package com.work.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.model.Product;
import com.work.productDto.ProductDto;
import com.work.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
//@Transactional
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public void createProduct(ProductDto productDto) {
		Product product = new Product();
		product.setId(productDto.getId());
		product.setLot_number(productDto.getLot_number());
		product.setName(productDto.getName());
		product.setQuantity(productDto.getQuantity());
		product.setWeight(productDto.getWeight());
		productRepository.save(product);

	}

	public List<ProductDto> getProducts() {
		List<Product> allProducts =  productRepository.findAll();
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for(Product product:allProducts) {
			productDtos.add(getProductDto(product));
		}
		return productDtos;
	}

	public ProductDto getProductDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setLot_number(product.getLot_number());
		productDto.setName(product.getName());
		productDto.setQuantity(product.getQuantity());
		productDto.setWeight(product.getWeight());
		return productDto;
	}
	

    @Transactional
    public Product editProduct(Integer id, Product updatedProduct) {


        // Fetch the existing product from the database
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

        // Update the existing product with the new data
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setQuantity(updatedProduct.getQuantity());
        existingProduct.setWeight(updatedProduct.getWeight());

        // Save the updated product
        return productRepository.save(existingProduct);
    }

	public void deleteUser(Integer id) {
		Optional<Product> deleteData = productRepository.findById(id);
		if (deleteData.isPresent()) {
			productRepository.deleteById(id);
		}
	}



}


