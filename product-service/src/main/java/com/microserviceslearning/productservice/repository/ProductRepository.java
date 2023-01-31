package com.microserviceslearning.productservice.repository;

import com.microserviceslearning.productservice.model.Product;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String>{

}
