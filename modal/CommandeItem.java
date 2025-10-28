package com.deepinsta.modal;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="commandeitem")
public class CommandeItem {
	@Id
	@Column(name="id_cmditem")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id_cmditem;	
	
	@ManyToOne
    private Product product;
	
	String color;
	
	String size;
	
	 @Column(name = "is_validated_admin")
	 boolean is_validated_admin;
	 
	@Column(name = "date_conf_by_admin")
	private LocalDateTime date_conf_by_admin;
	
	
	public long getId_cmditem() {
		return id_cmditem;
	}
	public void setId_cmditem(long id_cmditem) {
		this.id_cmditem = id_cmditem;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public boolean isIs_validated_admin() {
		return is_validated_admin;
	}
	public void setIs_validated_admin(boolean is_validated_admin) {
		this.is_validated_admin = is_validated_admin;
	}
	public LocalDateTime getDate_conf_by_admin() {
		return date_conf_by_admin;
	}
	public void setDate_conf_by_admin(LocalDateTime date_conf_by_admin) {
		this.date_conf_by_admin = date_conf_by_admin;
	}
	public CommandeItem() {
		super();
	}
	
	
	


	
	
}
