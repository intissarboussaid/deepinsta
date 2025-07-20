package com.deepinsta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deepinsta.modal.Avis;
import com.deepinsta.modal.Product;

@Repository
public interface AvisRepository extends JpaRepository<Avis, Long> {
	
	@Query("FROM Avis WHERE id_avis = :id_avis") 
	Avis  FindById(@Param("id_avis") long id_avis);
	
	@Query("FROM Avis WHERE product = :product") 
	List<Avis> FindByProduct(@Param("product") Product product);

	@Query("FROM Avis")
	List<Avis> GetAll();

}
