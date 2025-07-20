package com.deepinsta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deepinsta.modal.Admin;
import com.deepinsta.modal.Product_manager;


@Repository
public interface Product_managerRepository extends JpaRepository<Product_manager, Long> {
	
	@Query("FROM Product_manager WHERE id_pm = :id_pm") 
	Product_manager  findById(@Param("id_pm") long id_pm);

}
