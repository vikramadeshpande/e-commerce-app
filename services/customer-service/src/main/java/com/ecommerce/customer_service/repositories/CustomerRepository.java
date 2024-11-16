package com.ecommerce.customer_service.repositories;

import com.ecommerce.customer_service.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String > {

}
