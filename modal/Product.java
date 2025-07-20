package com.deepinsta.modal;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
	@Column(name="id_product")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id_product;
	@Column(name="prix_i")
	float prix_i;
	@Column(name="prix_f")
	float prix_f;
	@Column(name="name")
	String name;
	@Column(name="description")
	String description;
	@Column(name="prix_promotion")
	float prix_promotion;
	@Column(name="date")
	Date date;
	@Column(name="stock")
	String stock;
	@Column(name="qte")
	int qte;
	@Column(name="type")
	String type;
	@Column(name="percent")
	float percent;
	@ManyToOne
    @JoinColumn(name="id_cmd")
    private Commande cmd;
	@ManyToOne
	@JoinColumn(name="id_pm")
	private Product_manager pm;
	
	@OneToMany
	 @JoinColumn(name = "photo")
	private List<Photo> photos = new ArrayList<>();
	

	
	public long getId_product() {
		return id_product;
	}

	public void setId_product(long id_product) {
		this.id_product = id_product;
	}

	public float getPrix_i() {
		return prix_i;
	}

	public void setPrix_i(float prix_i) {
		this.prix_i = prix_i;
	}

	public float getPrix_f() {
		return prix_f;
	}

	public void setPrix_f(float prix_f) {
		this.prix_f = prix_f;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrix_promotion() {
		return prix_promotion;
	}

	public void setPrix_promotion(float prix_promotion) {
		this.prix_promotion = prix_promotion;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPercent() {
		return percent;
	}

	public void setPercent(float percent) {
		this.percent = percent;
	}

	public Commande getCmd() {
		return cmd;
	}

	public void setCmd(Commande cmd) {
		this.cmd = cmd;
	}

	public Product_manager getPm() {
		return pm;
	}

	public void setPm(Product_manager pm) {
		this.pm = pm;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	

/*	public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}*/

	public Product(float prix_i, float prix_f, String name, String description, float prix_promotion, Date date,
			String stock, int qte, String type, float percent, Commande cmd, Product_manager pm, List<Photo> photos) {
		super();
		this.prix_i = prix_i;
		this.prix_f = prix_f;
		this.name = name;
		this.description = description;
		this.prix_promotion = prix_promotion;
		this.date = date;
		this.stock = stock;
		this.qte = qte;
		this.type = type;
		this.percent = percent;
		this.cmd = cmd;
		this.pm = pm;
		this.photos = photos;
	}

	public Product() {
		super();
	}



	
	
}
