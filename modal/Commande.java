package com.deepinsta.modal;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="commande")
public class Commande {
	
	@Id
	@Column(name="id_cmd")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id_cmd;
	@Column(name = "total")
	Double total;

	
	@Column(name="quantity")
    private int quantity;
    @ManyToMany
    private List<CommandeItem> cmd_item;
	 @Column(name = "is_validated_user")
	 boolean is_validated_user;
	 @Column(name = "date_validated_by_user")
	 private LocalDateTime date_validated_by_user;	
	 @Column(name = "final_confirmation")
	 boolean final_confirmation;
	 @Column(name = "codePromo")
	 boolean codePromo;
    
    @ManyToOne
    private Users user;


	public long getId_cmd() {
		return id_cmd;
	}


	public void setId_cmd(long id_cmd) {
		this.id_cmd = id_cmd;
	}


	public boolean isCodePromo() {
		return codePromo;
	}


	public void setCodePromo(boolean codePromo) {
		this.codePromo = codePromo;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	


	public List<CommandeItem> getCmd_item() {
		return cmd_item;
	}


	public void setCmd_item(List<CommandeItem> cmd_item) {
		this.cmd_item = cmd_item;
	}


	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}


	public Commande() {
		super();
	}


	public boolean isIs_validated_user() {
		return is_validated_user;
	}


	public void setIs_validated_user(boolean is_validated_user) {
		this.is_validated_user = is_validated_user;
	}



	public LocalDateTime getDate_validated_by_user() {
		return date_validated_by_user;
	}


	public void setDate_validated_by_user(LocalDateTime date_validated_by_user) {
		this.date_validated_by_user = date_validated_by_user;
	}


	public boolean isFinal_confirmation() {
		return final_confirmation;
	}


	public void setFinal_confirmation(boolean final_confirmation) {
		this.final_confirmation = final_confirmation;
	}

    
    
    
    
    

}
