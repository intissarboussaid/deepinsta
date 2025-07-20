package com.deepinsta.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepinsta.modal.Account;
import com.deepinsta.service.AccountService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/deepinsta/account/")
@RequiredArgsConstructor
public class AccountController {

	AccountService accountService;
	public AccountController(AccountService accountService){
		this.accountService=accountService;
	}
	
	@GetMapping("getByEmail/{email}")
	public Account GetByEmail(@PathVariable("email") String email){
		return accountService.GetAccountByEmail(email);
	}
	

}
