package com.deepinsta.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="commande")
public class Commande {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cmd")
	long id_cmd;
	
	@Column(name = "referance")
	String referance;

	public long getId_cmd() {
		return id_cmd;
	}

	public void setId_cmd(long id_cmd) {
		this.id_cmd = id_cmd;
	}

	public String getReferance() {
		return referance;
	}

	public void setReferance(String referance) {
		this.referance = referance;
	}

	public Commande(long id_cmd, String referance) {
		super();
		this.id_cmd = id_cmd;
		this.referance = referance;
	}
	public Commande() {
		super();
	}

}
