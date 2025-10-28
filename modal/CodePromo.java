package com.deepinsta.modal;

import java.time.LocalDateTime;
import java.util.List;

import org.checkerframework.common.aliasing.qual.Unique;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="code_promo")
public class CodePromo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_code_promo")
	long id_code_promo;
	
	
	@Column(name="name")
	String name;
	
	@Column(name="code")
	String code;
	
	@Column(name="percent")
	Double percent;
	
	@ManyToOne
	private Admin admin ;	
	
	@ManyToMany
	private List<Users> user ;
	
	@Column(name = "start_date")
	private LocalDateTime start_date;
	@Column(name = "expiry_date")
	private LocalDateTime expiry_date;
	
	
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





	public Double getPercent() {
		return percent;
	}






	public void setPercent(Double percent) {
		this.percent = percent;
	}






	public Admin getAdmin() {
		return admin;
	}






	public void setAdmin(Admin admin) {
		this.admin = admin;
	}






	public List<Users> getUser() {
		return user;
	}






	public void setUser(List<Users> user) {
		this.user = user;
	}






	public LocalDateTime getStart_date() {
		return start_date;
	}






	public void setStart_date(LocalDateTime start_date) {
		this.start_date = start_date;
	}






	public LocalDateTime getExpiry_date() {
		return expiry_date;
	}






	public void setExpiry_date(LocalDateTime expiry_date) {
		this.expiry_date = expiry_date;
	}






	public CodePromo() {
		super();
	}
	
	

}
