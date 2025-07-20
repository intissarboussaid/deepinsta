package com.deepinsta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deepinsta.modal.Product;
import com.deepinsta.modal.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	
	@Query("FROM Users WHERE id_user = :id_user")
	Users GetById(@Param("id_user") long id_user);

}
