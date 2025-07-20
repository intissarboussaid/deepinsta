package com.deepinsta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deepinsta.modal.Code_Promo;

@Repository
public interface Code_PromoRepository extends JpaRepository<Code_Promo, Long>{

}
