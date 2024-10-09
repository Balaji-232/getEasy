package com.cart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cart.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
	
	@Query("Select r from Review r where r.Rid=:x")
	List<Review> findByPid(@Param("x") long Rid);
}
