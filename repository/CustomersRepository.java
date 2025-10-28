package com.deepinsta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.deepinsta.modal.Admin;
import com.deepinsta.modal.Customers;
import com.deepinsta.modal.User_Customer;

public interface CustomersRepository extends JpaRepository<Customers, Long> {
	
	@Query("FROM Customers WHERE admin = :admin")
	Customers findByAdmin(@Param("admin") Admin admin);
	/*@Query("SELECT c FROM Customers c WHERE c.admin = :admin AND c.user = :user ")
	Customers findByAdminAndUser(@Param("admin") Admin admin,@Param("user") Users user);*/

}
