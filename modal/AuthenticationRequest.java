package com.deepinsta.modal;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class AuthenticationRequest {
	 private String email;
	 private String username;	
	 private String psw;
	 private String confirmationpsw;
	 
	 
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPsw() {
		return psw;
	}
	
	public void setPsw(String psw) {
		this.psw = psw;
	}
	
	public String getConfirmationpsw() {
		return confirmationpsw;
	}
	public void setConfirmationpsw(String confirmationpsw) {
		this.confirmationpsw = confirmationpsw;
	}
	public AuthenticationRequest() {
		super();
	}
	 
	 
}
