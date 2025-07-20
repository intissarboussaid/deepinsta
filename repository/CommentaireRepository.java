package com.deepinsta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deepinsta.modal.Commentaire;


@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long>{

}
