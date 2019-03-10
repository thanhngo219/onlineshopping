package com.thanh.shopping.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.thanh.shopping.order.domain.Order;

public interface OrderRepository extends MongoRepository<Order, String> {

}
