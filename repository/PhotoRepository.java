package com.deepinsta.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deepinsta.modal.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long>{
	@Query("FROM Photo WHERE id_photo = :id_photo") 
	Photo  findById(@Param("id_photo") long id_photo);

}
