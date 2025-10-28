package com.deepinsta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deepinsta.modal.Admin;
import com.deepinsta.modal.Product;
import com.deepinsta.modal.Users;
import com.deepinsta.modal.ViewProduct;

@Repository
public interface ViewProductRepository extends JpaRepository<ViewProduct, Long>{


	boolean existsByProductAndUser(Product product, Users user);
	
	@Query("FROM ViewProduct WHERE product = :product") 
	List<ViewProduct>  findByIdProduct(@Param("product") Product product);

}
