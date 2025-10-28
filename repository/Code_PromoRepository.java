package com.deepinsta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deepinsta.modal.Admin;
import com.deepinsta.modal.CodePromo;
import com.deepinsta.modal.Users;

@Repository
public interface Code_PromoRepository extends JpaRepository<CodePromo, Long>{
	
	@Query("FROM CodePromo WHERE id_code_promo = :id_code_promo") 
	CodePromo  findById(@Param("id_code_promo") long id_code_promo);
	
	@Query("FROM CodePromo WHERE admin = :admin") 
	CodePromo  findByAdmin(@Param("admin") Admin admin);
	@Query("FROM CodePromo WHERE name = :name") 
	CodePromo  findByName(@Param("name") String name);
	
	boolean existsByCode(String code);

}
