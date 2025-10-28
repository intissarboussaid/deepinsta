package com.deepinsta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deepinsta.modal.Admin;
import com.deepinsta.modal.Commentaire;
import com.deepinsta.modal.Product;
import com.deepinsta.modal.Users;


@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long>{
	
	@Query("FROM Commentaire WHERE product = :product") 
	List<Commentaire>  findByProduct(@Param("product") Product product);
	
	@Query("FROM Commentaire WHERE user = :user") 
	List<Commentaire>  findByUser(@Param("user") Users user);
	@Query("FROM Commentaire WHERE admin = :admin") 
	List<Commentaire>  findByAdmin(@Param("admin") Admin admin);

}
