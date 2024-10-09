package com.cart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.entity.AddProduct;

public interface ShoppingRepository extends JpaRepository<AddProduct, Long>{
	
}