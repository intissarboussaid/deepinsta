package com.deepinsta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepinsta.modal.Admin;
import com.deepinsta.modal.Customers;
import com.deepinsta.modal.User_Customer;
import com.deepinsta.modal.Users;
import com.deepinsta.repository.CustomersRepository;
import com.deepinsta.repository.UserCustomerRepository;

@Service
public class CustomersService {
	
	@Autowired
	CustomersRepository customersRepository;
	@Autowired
	UserCustomerRepository userCustomersRepository;
	@Autowired
	AdminService adminService;
	
	public Customers AddCustomersByAdmin(Admin admin ,Users users) {
		Customers customer = customersRepository.findByAdmin(admin);
			
		if(customer!=null) {
			
				for(User_Customer use:customer.getUser_customer()) {
					if(use.getUser()==users) {
						int nbre=use.getNbre();
						nbre++;
						use.setNbre(nbre);						
						userCustomersRepository.save(use);
						customersRepository.save(customer);
						return customer;
					}
				}	
				
				
				List<User_Customer> allCustomers=customer.getUser_customer();
				User_Customer newUserCustomer= new User_Customer();
				newUserCustomer.setUser(users);
				
				int nbre=newUserCustomer.getNbre();
				nbre++;
				newUserCustomer.setNbre(nbre);						
				userCustomersRepository.save(newUserCustomer);
				allCustomers.add(newUserCustomer);
				customer.setUser_customer(allCustomers);
				customersRepository.save(customer);
				return customer;
		}else {
			Customers newCustomer =new Customers();
			newCustomer.setAdmin(admin);
			User_Customer newUserCustomer= new User_Customer();
			newUserCustomer.setUser(users);			
			int nbre=newUserCustomer.getNbre();
			nbre++;
			newUserCustomer.setNbre(nbre);
			userCustomersRepository.save(newUserCustomer);
			List<User_Customer> allCustomers=new ArrayList<>();
			allCustomers.add(newUserCustomer);
			newCustomer.setUser_customer(allCustomers);
			return customersRepository.save(newCustomer);
		}
		
	}
	
	public Customers getCustomersByAdmin(long id_admin) {
		Admin admin =adminService.findAdminById(id_admin);
		return customersRepository.findByAdmin(admin);
	}
	
	public User_Customer makeItFidele(long id_user_customer) {		
		User_Customer userCustomer=userCustomersRepository.findById(id_user_customer);
		userCustomer.setFidele(true);
		
		return userCustomersRepository.save(userCustomer);
	}
	public User_Customer makeItNotFidele(long id_user_customer) {		
		User_Customer userCustomer=userCustomersRepository.findById(id_user_customer);
		userCustomer.setFidele(false);
		
		return userCustomersRepository.save(userCustomer);
	}

}
