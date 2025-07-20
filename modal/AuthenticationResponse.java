package com.deepinsta.modal;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class AuthenticationResponse {
	
	String token;
	Account account;
	
	 public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getToken() {
		return token;
	}

	public AuthenticationResponse(String token,Account account) {
		super();
		this.token = token;
		this.account = account;
	}
	public AuthenticationResponse() {
		super();
	}


	public void setToken(String token) {
		this.token = token;
	}

	public static Builder builder() {
	        return new Builder();
	    }
	    
	    public static class Builder {
	        private String token;
	        private Account account;
	        
	        public Builder token(String token) {
	            this.token = token;
	            return this;
	        }
	        public Builder account(Account user) {
	            this.account = user;
	            return this;
	        }
	        
	        public AuthenticationResponse build() {
	            AuthenticationResponse response = new AuthenticationResponse();
	            response.token = this.token;
	            response.account=this.account;
	            return response;
	        }
	    }
}
