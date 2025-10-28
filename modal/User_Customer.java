package com.deepinsta.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user_customer")
public class User_Customer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_customer")
     long id_user_customer;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	Users user;
	
	@Column
	int nbre;
	
	@Column
	boolean isFidele;

	public long getId_user_customer() {
		return id_user_customer;
	}

	public void setId_user_customer(long id_user_customer) {
		this.id_user_customer = id_user_customer;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public int getNbre() {
		return nbre;
	}

	public void setNbre(int nbre) {
		this.nbre = nbre;
	}

	public boolean isFidele() {
		return isFidele;
	}

	public void setFidele(boolean isFidele) {
		this.isFidele = isFidele;
	}

	public User_Customer() {
		super();
	}

	public User_Customer(Users user, int nbre) {
		super();
		this.user = user;
		this.nbre = nbre;
	}
	
	
}
