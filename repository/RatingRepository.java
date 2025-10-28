package com.deepinsta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deepinsta.modal.Rating;
import com.deepinsta.modal.Users;
import com.deepinsta.modal.Admin;
import com.deepinsta.modal.Product;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
	
	@Query("FROM Rating WHERE id_rating = :id_rating") 
	Rating  FindById(@Param("id_rating") long id_rating);
	
	@Query("FROM Rating WHERE product = :product") 
	List<Rating> FindByProduct(@Param("product") Product product);
	
	@Query("FROM Rating WHERE user = :user") 
	List<Rating> FindByUser(@Param("user") Users user);
	@Query("FROM Rating WHERE admin = :admin") 
	List<Rating> FindByAdmin(@Param("user") Admin admin);
	
	@Query("FROM Rating WHERE user = :user AND product =:product") 
	Rating FindByUserAndProduct(@Param("user") Users user,@Param("product") Product product);
	@Query("FROM Rating WHERE admin = :admin AND product =:product") 
	Rating FindByAdminAndProduct(@Param("admin") Admin admin,@Param("product") Product product);
	
	@Query("FROM Rating WHERE product = :product AND starts =:starts") 
	List<Rating> FindBystarts(@Param("starts") Double starts,@Param("product") Product product);


}
