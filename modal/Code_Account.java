package com.deepinsta.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Code_Verfication")
public class Code_Account {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	long id_code;
	
    @Column(name = "code")
    private String code;

	public long getId_code() {
		return id_code;
	}

	public void setId_code(long id_code) {
		this.id_code = id_code;
	}

	public String getCode() {
		return code;
	}

	public Code_Account(long id_code, String code) {
		super();
		this.id_code = id_code;
		this.code = code;
	}

	public void setVerif_code(String code) {
		this.code = code;
	}

	public Code_Account(String code) {
		super();
		this.code = code;
	}
	public Code_Account() {
		super();
	}
    

}
