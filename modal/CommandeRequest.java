package com.deepinsta.modal;

import java.time.LocalDateTime;

public class CommandeRequest {
	
	
	 private String color;
	 private String size;	
	 private boolean conf_admin;
	 private boolean conf_user;
	 private LocalDateTime date_validated_by_user;
	 private LocalDateTime date_validated_by_admin;
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
	public boolean isConf_admin() {
		return conf_admin;
	}
	public void setConf_admin(boolean conf_admin) {
		this.conf_admin = conf_admin;
	}
	public boolean isConf_user() {
		return conf_user;
	}
	public void setConf_user(boolean conf_user) {
		this.conf_user = conf_user;
	}
	public LocalDateTime getDate_validated_by_user() {
		return date_validated_by_user;
	}
	public void setDate_validated_by_user(LocalDateTime date_validated_by_user) {
		this.date_validated_by_user = date_validated_by_user;
	}
	public LocalDateTime getDate_validated_by_admin() {
		return date_validated_by_admin;
	}
	public void setDate_validated_by_admin(LocalDateTime date_validated_by_admin) {
		this.date_validated_by_admin = date_validated_by_admin;
	}
	public CommandeRequest() {
		super();
	}
	 
	 
	 
	 

}
