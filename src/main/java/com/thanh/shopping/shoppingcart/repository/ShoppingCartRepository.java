package com.thanh.shopping.shoppingcart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.thanh.shopping.shoppingcart.domain.ShoppingCart;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {

}
