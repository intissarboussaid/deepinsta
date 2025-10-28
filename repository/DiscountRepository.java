package com.deepinsta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deepinsta.modal.Discount;
import com.deepinsta.modal.Product;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {

	@Query("FROM Discount WHERE id_discount = :id_discount") 
	Discount FindById(@Param("id_discount") long id_discount);
	@Query("FROM Discount WHERE product = :product") 
	List<Discount> FindByProduct(@Param("product") Product product);
}
