package com.thanh.shopping.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.thanh.shopping.domain.product.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
