package com.deepinsta.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="product_color")
public class ProductColor {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id_color;
	@Column(name="product_color")
	String product_color;
	public long getId_color() {
		return id_color;
	}
	public void setId_color(long id_color) {
		this.id_color = id_color;
	}
	public String getProduct_color() {
		return product_color;
	}
	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}
	public ProductColor(String product_color) {
		super();
		this.product_color = product_color;
	}
	public ProductColor() {
		super();
	}
	
}
