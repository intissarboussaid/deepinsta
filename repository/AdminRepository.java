package com.deepinsta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deepinsta.modal.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

	
	@Query("FROM Admin WHERE id_admin = :id_admin") 
	Admin  findById(@Param("id_admin") long id_admin);
}
