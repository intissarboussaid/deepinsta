package com.deepinsta.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deepinsta.modal.CommandeItem;
import com.deepinsta.modal.Product;

@Repository
public interface CommandeItemRepository extends JpaRepository<CommandeItem, Long>{
	@Query("FROM CommandeItem WHERE id_cmditem = :id_cmditem")
	CommandeItem findById(@Param("id_cmditem") long id_cmditem);
	@Query("FROM CommandeItem WHERE product = :product")
	CommandeItem findByProduct(@Param("product") Product product);
	
	@Query("FROM CommandeItem WHERE product = :product")
	List<CommandeItem> findByProducts(@Param("product") Product product);

}
