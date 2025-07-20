package com.deepinsta.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RegisterRequest {

	
	 private String email;	
	 private String psw;	
	 private String confirmationpsw;
	 private boolean is_enable;
	 private String phone;
	 private Role role;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public RegisterRequest() {
		super();
	}
	public boolean isIs_enable() {
		return is_enable;
	}
	public void setIs_enable(boolean is_enable) {
		this.is_enable = is_enable;
	}
	
	 
	 
}
