package com.deepinsta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.deepinsta.modal.User_Customer;

public interface UserCustomerRepository  extends JpaRepository<User_Customer, Long>{
	@Query("FROM User_Customer WHERE id_user_customer = :id_user_customer")
	User_Customer findById(@Param("id_user_customer") long id_user_customer);

}
