package com.deepinsta.modal;

import java.util.Date;
import java.util.List;

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
@Table(name="Product_manager")
public class Product_manager{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pm")
	long id_pm;
	@Column(name = "nom")
	String nom;
	@Column(name = "prenom")
	String prenom;
	@Column(name = "adresse")
	String adresse;
	@Column(name = "local")
	String local;
	@Column(name = "date_naissance")
	String date_naissance;
	@Column(name = "site")
	List<String> site;
	@Column(name = "sexe")
	String sexe;
	@Column(name = "nationnalité")
	String nationnalité;
	@Column(name = "instagramme")
	String instagramme;
	@Column(name = "facebook")
	String facebook;
	@Column(name = "tiktok")
	String tiktok;
	  @Column(name = "phone")
	    private String phone;
		@Column(name = "description")
		String description;
		  public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@OneToOne
	@JoinColumn(name = "id_photo")
    Photo photo;

	public long getId_pm() {
		return id_pm;
	}

	public void setId_pm(long id_pm) {
		this.id_pm = id_pm;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}

	public List<String> getSite() {
		return site;
	}

	public void setSite(List<String> site) {
		this.site = site;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getNationnalité() {
		return nationnalité;
	}

	public void setNationnalité(String nationnalité) {
		this.nationnalité = nationnalité;
	}

	public String getInstagramme() {
		return instagramme;
	}

	public void setInstagramme(String instagramme) {
		this.instagramme = instagramme;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTiktok() {
		return tiktok;
	}

	public void setTiktok(String tiktok) {
		this.tiktok = tiktok;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	public Product_manager(String nom, String prenom, String adresse, String local, String date_naissance,
			List<String> site, String sexe, String nationnalité, String instagramme, String facebook, String tiktok,
			Photo photo) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.local = local;
		this.date_naissance = date_naissance;
		this.site = site;
		this.sexe = sexe;
		this.nationnalité = nationnalité;
		this.instagramme = instagramme;
		this.facebook = facebook;
		this.tiktok = tiktok;
		this.photo = photo;
	}

	public Product_manager() {
		super();
	}
	
	

}
