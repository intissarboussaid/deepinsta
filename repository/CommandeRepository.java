package com.deepinsta.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deepinsta.modal.Commande;
import com.deepinsta.modal.CommandeItem;
import com.deepinsta.modal.Product;
import com.deepinsta.modal.Users;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
	
	@Query("SELECT c FROM Commande c WHERE :cmd_item MEMBER OF c.cmd_item")
	List<Commande> findByProduct(@Param("cmd_item") CommandeItem cmd_item);
	@Query("FROM Commande WHERE user = :user") 
	List<Commande>  findByUser(@Param("user") Users user);
	@Query("FROM Commande WHERE id_cmd = :id_cmd") 
	Commande getById(@Param("id_cmd") long id_cmd);
	@Query("SELECT c FROM Commande c WHERE c.user = :user AND c.is_validated_user = :is_validated_user AND c.final_confirmation = :final_confirmation")
	Commande getCmdAcceptedByUser(
	    @Param("user") Users user,
	    @Param("is_validated_user") boolean is_validated_user,
	    @Param("final_confirmation") boolean final_confirmation
	);
	@Query("SELECT c FROM Commande c WHERE c.user = :user AND c.is_validated_user = :is_validated_user AND c.final_confirmation = :final_confirmation")
	List<Commande> getCmdsAcceptedByUser(
	    @Param("user") Users user,
	    @Param("is_validated_user") boolean is_validated_user,
	    @Param("final_confirmation") boolean final_confirmation
	);
	
	@Query("SELECT c FROM Commande c WHERE c.user = :user AND :cmd_item MEMBER OF c.cmd_item AND c.is_validated_user = :is_validated_user AND c.final_confirmation = :final_confirmation")
	Commande getCmdByUserAndProduct(
	    @Param("user") Users user,
	    @Param("cmd_item") CommandeItem cmd_item,
	    @Param("is_validated_user") boolean is_validated_user,
	    @Param("final_confirmation") boolean final_confirmation
	);
	
	@Query("FROM Commande WHERE is_validated_user=:is_validated_user And final_confirmation=:final_confirmation")
	List<Commande> getCmdsConfByUserAndNotByAdmin (
	    @Param("is_validated_user") boolean is_validated_user,
	    @Param("final_confirmation") boolean final_confirmation
	);



}
