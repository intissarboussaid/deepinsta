package com.deepinsta.modal;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_discount")
     long id_discount;
    @Column(name = "discount_price")
    private Double discount_price;
    @Column(name = "discount_percentage")  
    private Double discount_percentage;
    @Column(name="date")
	LocalDateTime date;
    
    @ManyToOne
    @JsonBackReference
    private Product product;
    
	public long getId_discount() {
		return id_discount;
	}
	public void setId_discount(long id_discount) {
		this.id_discount = id_discount;
	}
	public Double getDiscount_price() {
		return discount_price;
	}
	public void setDiscount_price(Double discount_price) {
		this.discount_price = discount_price;
	}
	public Double getDiscount_percentage() {
		return discount_percentage;
	}
	public void setDiscount_percentage(Double discount_percentage) {
		this.discount_percentage = discount_percentage;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public Discount(long id_discount, Double discount_price, Double discount_percentage) {
		super();
		this.id_discount = id_discount;
		this.discount_price = discount_price;
		this.discount_percentage = discount_percentage;
	}
    
	public Discount() {
		super();
	}
    
}
