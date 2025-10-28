package com.deepinsta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.deepinsta.modal.Product;
import com.deepinsta.modal.Admin;
import com.deepinsta.modal.Favorite;
import com.deepinsta.modal.Users;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
	
	@Query("FROM Favorite WHERE id_fav = :id_fav") 
	Favorite  FindById(@Param("id_rating") long id_rating);
	
	@Query("FROM Favorite WHERE product = :product") 
	List<Favorite> FindByProduct(@Param("product") Product product);
	
	@Query("FROM Favorite WHERE user = :user") 
	List<Favorite> FindByUser(@Param("user") Users user);
	@Query("FROM Favorite WHERE admin = :admin") 
	List<Favorite> FindByAdmin(@Param("admin") Admin admin);
	
	@Query("FROM Favorite WHERE user = :user AND product =:product") 
	Favorite FindByUserAndProduct(@Param("user") Users user,@Param("product") Product product);
	@Query("FROM Favorite WHERE admin = :admin AND product =:product") 
	Favorite FindByAdminAndProduct(@Param("admin") Admin admin,@Param("product") Product product);

}
