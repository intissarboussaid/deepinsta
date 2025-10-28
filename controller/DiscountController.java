package com.deepinsta.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepinsta.modal.Discount;
import com.deepinsta.service.DiscountService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/deepinsta/discount")
public class DiscountController {
	
	private DiscountService discountService;
	
	public DiscountController(DiscountService discountService) {
		this.discountService=discountService;
	}
	@PostMapping("/add/discount/{id_product}")
	public Discount addDiscount(@PathVariable("id_product") long id_product,@RequestBody Discount discount) {
		return discountService.addDiscount(id_product,discount);
	}
	@GetMapping("/get/by/admin/{id_admin}")
	public List<Discount> getAllDiscountsByAdmin(@PathVariable("id_admin") long id_admin) {
		return discountService.GetAllDiscountsByAdmin(id_admin);
	}
	@GetMapping("/update/discount/{id_discount}")
	public Discount  updateDateDiscount(@PathVariable("id_discount") long id_discount) {
		return discountService.addDateDiscount(id_discount);
	}


}
