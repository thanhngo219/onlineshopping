package com.thanh.shopping.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.thanh.shopping.domain.shoppingcart.ShoppingCart;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {

}
