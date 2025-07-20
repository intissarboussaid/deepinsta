package com.deepinsta.modal;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
public class Account implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account")
     long id_account;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "psw")
    private String psw;

   // @Transient  // Don't store this in DB
    @Column(name = "confirmationpsw")
    private String confirmationpsw;

  
    @Column(name = "token")
    private String token;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(name = "is_enable")
    private boolean is_enable;

    @OneToOne
    @JoinColumn(name = "id_admin")
    private Admin admin;
    @OneToOne
    @JoinColumn(name = "id_user")
    private Users user;
    @OneToOne
    @JoinColumn(name = "code")
    private Code_Account code;
    @OneToOne
    @JoinColumn(name = "id_pm")
    private Product_manager product_manager;
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
    	 private String email;
    	 private String psw;
    	 private String confirmationpsw;
    	 private Role role;
    	 private boolean is_enable;
        
    	 public Builder email( String email) {
            this.email = email;
            return this;
        }
    	 public Builder psw(String psw) {
           
             this.psw = psw;
            
             return this;
         }
    	 public Builder confirmationpsw(String confirmationpsw) {
             this.confirmationpsw = confirmationpsw;
             return this;
         }
    	 public Builder role(Role role) {
             this.role = role;
             return this;
         }
    	 public Builder is_enable(boolean is_enable) {
    		 this.is_enable = is_enable;
 			return this;
 		}

        public Account build() {
        	Account response = new Account();
            //response.token = this.token;
            response.email = this.email;
            response.psw = this.psw;
            response.confirmationpsw = this.confirmationpsw;
            response.role = this.role;
            response.is_enable=this.is_enable;
            return response;
        }
		
	
    }
    

	public Code_Account getCode() {
		return code;
	}

	public void setCode(Code_Account code) {
		this.code = code;
	}

	public long getId_account() {
		return id_account;
	}

	public void setId_account(long id_account) {
		this.id_account = id_account;
	}

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

	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isIs_enable() {
		return is_enable;
	}

	public void setIs_enable(boolean is_enable) {
		this.is_enable = is_enable;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Account(String email, String psw, String confirmationpsw, Role role, boolean is_enable,
			Admin admin) {
		super();
		this.email = email;
		this.psw = psw;
		this.confirmationpsw = confirmationpsw;
		this.role = role;
		this.is_enable = is_enable;
		this.admin = admin;
	}

	public Account() {
		super();
	}
	
	

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Product_manager getProduct_manager() {
		return product_manager;
	}

	public void setProduct_manager(Product_manager product_manager) {
		this.product_manager = product_manager;
	}
	
	

	public Account(Admin admin) {
		super();
		this.admin = admin;
	}
	

	public Account(Users user) {
		super();
		this.user = user;
	}

	public Account(Product_manager product_manager) {
		super();
		this.product_manager = product_manager;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return psw;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // Or implement expiration logic
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // Or implement locking logic
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Or implement credential expiration logic
    }

    @Override
    public boolean isEnabled() {
        return is_enable;
    }
}
