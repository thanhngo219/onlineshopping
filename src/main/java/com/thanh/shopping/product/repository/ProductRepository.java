package com.thanh.shopping.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.thanh.shopping.product.domain.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
