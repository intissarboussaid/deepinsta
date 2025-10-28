package com.deepinsta.modal;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Customers {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
     long id_customer;
	
	@ManyToMany
	private List<User_Customer> user_customer ;	
	
	@OneToOne
	@JoinColumn(name = "admin")
	private Admin admin;


	public long getId_customer() {
		return id_customer;
	}

	public void setId_customer(long id_customer) {
		this.id_customer = id_customer;
	}



	public List<User_Customer> getUser_customer() {
		return user_customer;
	}

	public void setUser_customer(List<User_Customer> user_customer) {
		this.user_customer = user_customer;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Customers() {
		super();
	}

	public Customers(List<User_Customer> user_customer, Admin admin) {
		super();
		this.user_customer = user_customer;
		this.admin = admin;
	}
	
	
	

}
