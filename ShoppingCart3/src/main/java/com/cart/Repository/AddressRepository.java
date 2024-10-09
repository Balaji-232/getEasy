package com.cart.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cart.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Integer> {
	
	@Query("select r from Address r where r.sId=:x")
	Iterable<Address> findBySid(@Param("x") int sId);
}
