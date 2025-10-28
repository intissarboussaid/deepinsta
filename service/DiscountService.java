package com.deepinsta.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepinsta.modal.Admin;
import com.deepinsta.modal.Discount;
import com.deepinsta.modal.Product;
import com.deepinsta.repository.DiscountRepository;

@Service
public class DiscountService {

	private DiscountRepository discountRepository;
	private ProductService productService;
	@Autowired
	private AdminService adminService;
	
	
	public DiscountService(DiscountRepository discountRepository,ProductService productService) {
		this.discountRepository=discountRepository;	
		this.productService=productService;
	}	
	public Discount addDiscount(long id,Discount discount) {
		Product product= productService.GetProductById(id);
		discount.setProduct(product);
		discount.setDiscount_price(product.getSale_price()*(1-(discount.getDiscount_percentage()/100.0)));
		product.setDiscount_price(discount.getDiscount_price());
		product.setDiscount_percent(discount.getDiscount_percentage());
		discount.setDate(LocalDateTime.now());
		return discountRepository.save(discount);
	}
	
	public List<Discount> GetAllDiscountsByAdmin(long id_admin){
		Admin admin =adminService.findAdminById(id_admin);
		List<Discount> discounts= discountRepository.findAll();
		List<Discount>discountsByAdmin=new ArrayList<>();
		for(Discount discount :discounts) {
			if(discount.getProduct().getAdmin()==admin) {
				discountsByAdmin.add(discount);
			}
		}
		
		return discountsByAdmin ;
	}
	public Discount GetDiscountById(long id) {
		return discountRepository.FindById(id);
	}
	public Discount addDateDiscount(long id) {
		Discount discount =GetDiscountById(id);
		if(discount.getDate()==null) {
			discount.setDate(LocalDateTime.now());
			return discountRepository.save(discount);
		}
		return discount;
	}

	
	
}
