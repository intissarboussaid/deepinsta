package com.deepinsta.modal;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;

@Table(name="favorite")
@Entity
public class Favorite {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="id_fav")
	 long id_fav;
	 boolean isfav;
	@ManyToOne
	private Product product;	 
	 @ManyToOne
   private Users user;
	 @ManyToOne
	   private Admin admin;
	public long getId_fav() {
		return id_fav;
	}
	public void setId_fav(long id_fav) {
		this.id_fav = id_fav;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
	public boolean isIsfav() {
		return isfav;
	}
	public void setIsfav(boolean isfav) {
		this.isfav = isfav;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Favorite() {
		super();
	}
	

}
