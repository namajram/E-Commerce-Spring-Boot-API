package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.entities.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
