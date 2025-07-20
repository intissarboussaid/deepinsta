package com.deepinsta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepinsta.modal.Account;
import com.deepinsta.service.AccountService;
import com.deepinsta.service.EmailService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/deepinsta/sendEmail/")
@RequiredArgsConstructor
public class SendEmailController {
	@Autowired
	EmailService emailService;
	@Autowired
	AccountService accountService;
	

	

}
