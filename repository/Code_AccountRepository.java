package com.deepinsta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deepinsta.modal.Code_Account;

@Repository
public interface Code_AccountRepository extends JpaRepository<Code_Account, Long> {

}
