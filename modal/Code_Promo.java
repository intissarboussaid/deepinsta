package com.deepinsta.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="code_promo")
public class Code_Promo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_code_promo")
	long id_code_promo;
	
	@Column(name="name")
	String name;
	
	@Column(name="code")
	String code;
	
	@Column(name="montant_code")
	float montant_code;
	
	@Column(name="prix_ff")
	float prix_ff;
	
	@ManyToOne
	Product product;

	public long getId_code_promo() {
		return id_code_promo;
	}

	public void setId_code_promo(long id_code_promo) {
		this.id_code_promo = id_code_promo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public float getMontant_code() {
		return montant_code;
	}

	public void setMontant_code(float montant_code) {
		this.montant_code = montant_code;
	}

	public float getPrix_ff() {
		return prix_ff;
	}

	public void setPrix_ff(float prix_ff) {
		this.prix_ff = prix_ff;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Code_Promo(String name, String code, float montant_code, float prix_ff, Product product) {
		super();
		this.name = name;
		this.code = code;
		this.montant_code = montant_code;
		this.prix_ff = prix_ff;
		this.product = product;
	}

	public Code_Promo() {
		super();
	}
	
	

}
