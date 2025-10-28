package com.deepinsta.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="color_qte")
public class Color_qte {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cq")
     long id_cq;
	
	String color;
	int qte;
	String size;
	@Column(name = "rest_qte")
	int rest_qte;
	public long getId_cq() {
		return id_cq;
	}
	public void setId_cq(long id_cq) {
		this.id_cq = id_cq;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	public int getRest_qte() {
		return rest_qte;
	}
	public void setRest_qte(int rest_qte) {
		this.rest_qte = rest_qte;
	}
	public Color_qte() {
		super();
	}
	
	

}
