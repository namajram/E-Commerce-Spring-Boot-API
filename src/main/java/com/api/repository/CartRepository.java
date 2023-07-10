package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.entities.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	List<Cart> findByUser_UserId(Long userId);
	List<Cart> findByUser(Long userId);
}
