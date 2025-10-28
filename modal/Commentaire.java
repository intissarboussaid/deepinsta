package com.deepinsta.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="commentaire")
public class Commentaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_commentaire")
	long id_commentaire;
	
	@Column(columnDefinition = "TEXT") 
	String commentaire;
	
	@Column(name="nbre")
	long nbre;
		
	@ManyToOne
	Product product;
	
	@ManyToOne
	Users user;
	@ManyToOne
	Admin admin;
	public long getId_commentaire() {
		return id_commentaire;
	}

	public void setId_commentaire(long id_commentaire) {
		this.id_commentaire = id_commentaire;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public long getNbre() {
		return nbre;
	}

	public void setNbre(long nbre) {
		this.nbre = nbre;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Commentaire(String commentaire, long nbre, Product product) {
		super();
		this.commentaire = commentaire;
		this.nbre = nbre;
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

	public Commentaire() {
		super();
	}
	

}
