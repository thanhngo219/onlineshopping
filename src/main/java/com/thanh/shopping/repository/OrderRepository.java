package com.thanh.shopping.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.thanh.shopping.domain.order.Order;

public interface OrderRepository extends MongoRepository<Order, String> {

}
