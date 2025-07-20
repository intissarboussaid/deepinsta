package com.deepinsta.modal;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="avis")
public class Avis {

	
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="id_avis")
	long id_avis;
	
	@Column(name = "nbre_avis")
	private long nbre_avis;
	 
	@Column(name = "count_avis")
	private long count_avis;
	
	
	@OneToOne
	@JoinColumn(name = "users")
    private Users users;
	
	
	@Column(name = "percentage")
	private float percentage;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product")
	private Product product;
	


	public long getId_avis() {
		return id_avis;
	}

	public void setId_avis(long id_avis) {
		this.id_avis = id_avis;
	}

	public long getNbre_avis() {
		return nbre_avis;
	}

	public void setNbre_avis(long nbre_avis) {
		this.nbre_avis = nbre_avis;
	}

	public long getCount_avis() {
		return count_avis;
	}

	public void setCount_avis(long count_avis) {
		this.count_avis = count_avis;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}



	public Users getUser() {
		return users;
	}

	public void setUser(Users user) {
		this.users = user;
	}



	
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}



	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Avis(long nbre_avis, long count_avis, Users users, float percentage, Product product) {
		super();
		this.nbre_avis = nbre_avis;
		this.count_avis = count_avis;
		this.users = users;
		this.percentage = percentage;
		this.product = product;
	}

	public Avis() {
		super();
	}

	
	
}
