package com.deepinsta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepinsta.config.JwtAuthenticationFilter;
import com.deepinsta.modal.Account;
import com.deepinsta.modal.AuthenticationRequest;
import com.deepinsta.modal.AuthenticationResponse;
import com.deepinsta.modal.RegisterRequest;
import com.deepinsta.repository.AccountRepository;
import com.deepinsta.service.AuthenticationService;
import com.deepinsta.service.EmailService;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/deepinsta/auth/")
@RequiredArgsConstructor
public class AuthenticationController {
	@Autowired
	AccountRepository accoutRepository;
	private AuthenticationService authenticationService;
	 
	
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
     }

	@PostMapping("register")
	public ResponseEntity<?> register(@RequestBody RegisterRequest request) throws MessagingException{
		return ResponseEntity.ok(authenticationService.register(request));
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authRequest){
		return ResponseEntity.ok(authenticationService.authenticate(authRequest));
	}
	@GetMapping("GetAll/account")
	public List<Account> GetAllAccount(){
		return authenticationService.GetAllAccount();
	} 
	@GetMapping("getByEmail/{email}")
	public Account GetByEmail(@PathVariable("email") String email){
		return authenticationService.GetByEmail(email);
	}
	@GetMapping("getById/account/{id_account}")
	public Account GetByIdAccount(@PathVariable("id_account") long id_account){
		return authenticationService.GetByIdAccount(id_account);
	}
	
	@GetMapping("activate/account/{id_account}")
	public Account ActivateAccount(@PathVariable("id_account") long id_account){
		Account account=authenticationService.GetByIdAccount(id_account);
		account.setIs_enable(true);
		return accoutRepository.save(account);
	}
	@PutMapping("forgetPSW/{id_account}")
	public Account ForgetPassword(@PathVariable("id_account") long id_account,@RequestBody Account acc){
		Account account=authenticationService.forgetPsw(id_account,acc);
		return account;
	}
	
}
