package com.deepinsta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deepinsta.modal.Admin;
import com.deepinsta.modal.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	

	
	@Query("FROM Product WHERE name = :name")
	List<Product> GetProductByName(@Param("name") String name);
	
	@Query("FROM Product WHERE type = :type")
	List<Product> GetProductByType(@Param("type") String type);
	
	@Query("FROM Product WHERE admin = :admin")
	List<Product> GetProductByAdmin(@Param("admin") Admin admin);
	
	@Query("FROM Product WHERE id_product = :id_product")
	Product GetProductById(@Param("id_product") long id_product);
	
	@Query("FROM Product WHERE sale_price >= :sale_price")
	List<Product> GetProductByPrice(@Param("sale_price") double sale_price);
	
	@Query("FROM Product WHERE sale_price <= :sale_price")
	List<Product> GetProductByLessPrice(@Param("sale_price") double sale_price);
}
