package com.deepinsta.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deepinsta.modal.Account;
import com.deepinsta.modal.Admin;
import com.deepinsta.modal.Users;

@Repository 
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	//@Query("FROM Account WHERE email = :email")
	//Optional<Account> findByEmail(@Param("email") String email);
	@Query("FROM Account  WHERE email = :email") 
	Account getByEmail(@Param("email") String email);
	@Query("FROM Account WHERE id_account = :id_account") 
	Account  findById(@Param("id_account") long id_account);
	@Query("FROM Account WHERE admin = :admin") 
	Account  findByAdmin(@Param("admin") Admin admin);
	@Query("FROM Account WHERE user = :user") 
	Account  findByUser(@Param("user") Users user);


}
