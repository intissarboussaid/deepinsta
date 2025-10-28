package com.deepinsta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.deepinsta.modal.Color_qte;

public interface ColorSizeQteRepository extends JpaRepository<Color_qte, Long> {
	
	@Query("FROM Color_qte WHERE color = :color") 
	List<Color_qte>  findByColor(@Param("color") String color);
	@Query("FROM Color_qte WHERE size = :size") 
	List<Color_qte>  findBysize(@Param("size") String size);

}
