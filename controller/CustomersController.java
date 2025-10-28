package com.deepinsta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepinsta.modal.Customers;
import com.deepinsta.modal.User_Customer;
import com.deepinsta.service.CustomersService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/deepshop/customers/")
@RequiredArgsConstructor
public class CustomersController {
	
	@Autowired
	private CustomersService customersService;
	
	@GetMapping("by/admin/{id_admin}")
	public Customers getCustomerByAdmin(@PathVariable("id_admin") long id_admin) {
		return customersService.getCustomersByAdmin(id_admin);
	}
	
	@GetMapping("fidele/client/{id_user_customer}")
	public User_Customer makeItFidele(@PathVariable("id_user_customer") long id_user_customer) {
		return customersService.makeItFidele(id_user_customer);
		
	}
	@GetMapping("Notfidele/client/{id_user_customer}")
	public User_Customer makeItNotFidele(@PathVariable("id_user_customer") long id_user_customer) {
		return customersService.makeItNotFidele(id_user_customer);
		
	}

}
