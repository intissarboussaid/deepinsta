package com.deepinsta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepinsta.modal.Account;
import com.deepinsta.modal.Admin;
import com.deepinsta.modal.Users;
import com.deepinsta.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	
	public Account GetAccountById(long id) {
		return  accountRepository.findById(id);
	}
	public Account GetAccountByEmail(String email) {
		return  accountRepository.getByEmail(email);
	}
	public Account getAccountByAdmin(Admin admin) {
		return accountRepository.findByAdmin(admin);
	}
	public Account getAccountByUser(Users user) {
		return accountRepository.findByUser(user);
	}
	

}
