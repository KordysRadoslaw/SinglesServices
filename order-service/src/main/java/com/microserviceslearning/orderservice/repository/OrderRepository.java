package com.microserviceslearning.orderservice.repository;

import com.microserviceslearning.orderservice.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
