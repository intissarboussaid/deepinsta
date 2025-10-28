package com.deepinsta.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepinsta.modal.Admin;
import com.deepinsta.modal.ContactBody;
import com.deepinsta.service.EmailService;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/deepshop/contact/")
@RequiredArgsConstructor
public class ContactController {
	@Autowired
	EmailService emailService;
	
	
	@PostMapping("send")
    public void UpdateSitedmin(@RequestBody ContactBody body) throws IOException, MessagingException {
    	emailService.sendMessageContact(body);
    }

}
