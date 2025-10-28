package com.deepinsta.modal;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="rating")
public class Rating {

	
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="id_rating")
	 long id_rating;
	 @Column(name="starts")
	 Double starts; 

	@ManyToOne
	private Product product;
	 
	 @ManyToOne
    private Users user;
	 @ManyToOne
	    private Admin admin;

	public long getId_rating() {
		return id_rating;
	}

	public void setId_rating(long id_rating) {
		this.id_rating = id_rating;
	}

	public Double getStarts() {
		return starts;
	}

	public void setStarts(Double starts) {
		this.starts = starts;
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Rating() {
		super();
	}
	

	
	
}
