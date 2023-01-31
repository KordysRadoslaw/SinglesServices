package com.microserviceslearning.productservice.service;

import java.util.List;

import com.microserviceslearning.productservice.dto.ProductRequest;
import com.microserviceslearning.productservice.dto.ProductResponse;
import com.microserviceslearning.productservice.model.Product;
import com.microserviceslearning.productservice.repository.ProductRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
	
	private final ProductRepository productRepository;
	
	// i dont need that, because i used @requeiredargsconstructor
//	public ProductService(ProductRepository productRepository) {
//		this.productRepository = productRepository;
//	}
	
	
	public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
		
		productRepository.save(product);
		//I'm using Slf4J so i can write like below
//		log.info("Product " + product.getId() + "is saved");
		log.info("Product {} is saved", product.getId());
	}

	public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
		
//		products.stream().map(product -> mapToProductResponse(product));
		//below i used lambda
        return products.stream().map(this::mapToProductResponse).toList();
        
	}
	
	private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
		
	}

}
