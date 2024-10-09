package com.cart.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cart.entity.SignUp;

public interface SignUpRepository extends JpaRepository<SignUp,Long> {
	
	@Query("select r from SignUp r where r.Email=:x and r.Password=:y")
	Optional<SignUp> findByEmailAndPassword(@Param("x") String Email, @Param("y") String Password);
	
	@Query("select r from SignUp r where r.Email=:x")
	Optional<SignUp> findByEmail(@Param("x") String Email);
}
