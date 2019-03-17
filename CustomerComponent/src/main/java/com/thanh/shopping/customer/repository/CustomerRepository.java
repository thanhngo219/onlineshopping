package com.thanh.shopping.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.thanh.shopping.customer.domain.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
