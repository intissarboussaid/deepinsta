package com.deepinsta.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.deepinsta.config.JwtService;
import com.deepinsta.modal.Account;
import com.deepinsta.modal.Admin;
import com.deepinsta.modal.AuthenticationRequest;
import com.deepinsta.modal.AuthenticationResponse;
import com.deepinsta.modal.Product_manager;
import com.deepinsta.modal.RegisterRequest;
import com.deepinsta.modal.Role;
import com.deepinsta.modal.Users;
import com.deepinsta.repository.AccountRepository;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	@Autowired
	private EmailService emailService;
    private final AdminService adminService;
    private Product_managerService product_managerService;
    private UsersService usersService;
    private  JwtService jwtService;
	
	private final  AccountRepository accountRepository;
	private final  PasswordEncoder passwordEncoder;
	private  final AuthenticationManager authenticationManager;
	

    AuthenticationService(JwtService jwtService,AccountRepository accountRepository,AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, AdminService adminService,UsersService usersService,Product_managerService product_managerService) {
        this.jwtService = jwtService;
		this.accountRepository = accountRepository;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
		this.adminService = adminService;
		this.product_managerService = product_managerService;
		this.usersService = usersService;
    }
	
	public ResponseEntity<?> register (RegisterRequest request) throws MessagingException {

		Account account =Account.builder()
				.email(request.getEmail())
				.psw(passwordEncoder.encode(request.getPsw()))
				.confirmationpsw(passwordEncoder.encode(request.getConfirmationpsw()))
				.role(request.getRole())
				.is_enable(request.isIs_enable())
				.build();
		
		if(request.getRole() ==Role.ADMIN) {
			Admin admin = new Admin();
			adminService.CreateAdmin(admin);
			account.setAdmin(admin);
		}
		if(request.getRole() ==Role.PRODUCTMANAGER) {
			Product_manager product_manager = new Product_manager();
			product_managerService.AddProduct_manager(product_manager);
			account.setProduct_manager(product_manager);
		}
		if(request.getRole() ==Role.USER) {
			Users user = new Users();
			usersService.AddUser(user);
			account.setUser(user);
		}
		var jwtToken = jwtService.generateToken(account);
		account.setToken(jwtToken);
		AuthenticationResponse response = AuthenticationResponse.builder()
	            .token(jwtToken)
	            .account(account)
	            .build();
		if(!request.getPsw().equals(request.getConfirmationpsw()) ) {
			return  ResponseEntity
	                .status(HttpStatus.FORBIDDEN)
	                .body("Password and confirmation password do not match");
		}
		System.out.println("email:"+account.getEmail());
		System.out.println("psw: "+account.getPsw());
	    System.out.println("Account: "+account);
		accountRepository.save(account);		
		//UserDetails user=(UserDetails) account;
		String htmlBody = "<!DOCTYPE html>" +
			    "<html>" +
			    "<body style='font-family: Arial, sans-serif; background-color: #ffffff; padding: 20px;'>" +
			    "  <table width='100%' cellspacing='0' cellpadding='0' border='0' align='center'>" +
			    "    <tr>" +
			    "      <td align='center'>" +
			    "        <table width='600' cellpadding='0' cellspacing='0' style='background-color: #EDE0D4; border-radius: 20px; padding: 40px;'>" +
			    "          <tr>" +
			    "            <td style='text-align: center; font-size: 28px; font-weight: bold; color: #5a3c28;'>WE'RE GLAD YOU ARE HERE</td>" +
			    "          </tr>" +
			    "          <tr>" +
			    "            <td style='text-align: center; padding: 30px 0;'>" +
			    "              <a href='http://localhost:4200/activateAccount' style='display: inline-block; padding: 15px 30px; background-color: #7F5539; color: #EDE0D4; text-decoration: none; border-radius: 30px; font-size: 16px;'>Go To Activate Account</a>" +
			    "            </td>" +
			    "          </tr>" +
			    "          <tr>" +
			    "            <td style='text-align: center; font-size: 18px; color: #5a3c28;'>Just confirming you're you.</td>" +
			    "          </tr>" +
			    "        </table>" +
			    "      </td>" +
			    "    </tr>" +
			    "  </table>" +
			    "</body>" +
			    "</html>";
		emailService.sendHtmlEmail(account.getEmail(), "Activate your Account", htmlBody);
		
		return ResponseEntity.ok(response);
	}
	

	public AuthenticationResponse authenticate (AuthenticationRequest request) {
		System.out.println("test: ");
		Authentication authentication =  authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(
	                    request.getEmail(),
	                    request.getPsw()
	                )
	            );
		System.out.println("test: ");
		 Account userDetails = (Account) authentication.getPrincipal();
		Account account=accountRepository.getByEmail(request.getEmail());
		//.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		
		System.out.println("Account: "+accountRepository.getByEmail(request.getEmail()));
		//.orElseThrow(() -> new UsernameNotFoundException("User not found")));
		var jwtToken = jwtService.generateToken(account);
		System.out.println("Account : "+accountRepository.getByEmail(request.getEmail()));
		//.orElseThrow(() -> new UsernameNotFoundException("User not found")));
		//System.out.println("JWTToken: "+jwtToken);
		return AuthenticationResponse.builder().token(jwtToken).account(account).build();
		
	}
	
	public AuthenticationResponse authenticateUser(AuthenticationRequest loginRequest) {
		System.out.println("test email request: "+loginRequest.getEmail());
	    Authentication authentication = authenticationManager
	        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPsw()));
	    System.out.println("test email request: "+loginRequest.getEmail());
	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    String jwt = jwtService.generateJwtToken(authentication);

	    Account userDetails = (Account) authentication.getPrincipal();
	   

	    return new AuthenticationResponse(jwt, userDetails);
	  }
	
	public List<Account>GetAllAccount() {
		
		return accountRepository.findAll();
	}

	public Account GetByEmail(String email) {
		//System.out.println("email: "+accountRepository.findByEmail(email));
		System.out.println("psw"+accountRepository.getByEmail(email).getPassword());
		return  accountRepository.getByEmail(email);
	}
	public Account GetByIdAccount(long id_account) {
		System.out.println("id account: "+accountRepository.findById(id_account));
		return  accountRepository.findById(id_account);
	}
	public Account forgetPsw(long id_account, Account account ) {
		 Account acc =accountRepository.findById(id_account);
		 acc.setPsw(account.getPsw());
		 acc.setConfirmationpsw(account.getConfirmationpsw());
		return  accountRepository.save(account);
	}

}
