package com.cart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cart.entity.CartDto;

public interface CartRepository extends JpaRepository<CartDto, Long> {
	
	@Query("Select r from CartDto r where r.SId=:x")
	List<CartDto> findBySid(@Param("x") int SId);
}
