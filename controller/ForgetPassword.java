package com.deepinsta.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deepinsta.modal.Account;
import com.deepinsta.modal.Code_Account;
import com.deepinsta.repository.AccountRepository;
import com.deepinsta.repository.Code_AccountRepository;
import com.deepinsta.service.AccountService;
import com.deepinsta.service.EmailService;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/deepinsta/forgetPassword/")
@RequiredArgsConstructor
public class ForgetPassword {

    private final AccountRepository accountRepository;
	
	
	  @Autowired
	    private EmailService emailService;
	  @Autowired
	    private AccountService accountService;
	  @Autowired
	    private Code_AccountRepository codeRepository;
	  @Autowired
	 PasswordEncoder passwordEncoder;

	    private Map<String, String> resetCodes = new HashMap<>();

    ForgetPassword(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

	    @PostMapping("request-reset/{email}")
	    public Account requestReset(@PathVariable("email") String email) throws MessagingException {
	    	Account account =accountService.GetAccountByEmail(email);
	    	if(account!=null) {
	        String code = UUID.randomUUID().toString().substring(0, 6).toUpperCase(); // 6-char code
	        System.out.println("code "+code);
	        resetCodes.put(email, code);
	        
	        String htmlBody = "<!DOCTYPE html>" +
	        	    "<html>" +
	        	    "<body style='font-family: Arial, sans-serif; background-color: #ffffff; padding: 20px;'>" +
	        	    "  <table width='100%' cellspacing='0' cellpadding='0' border='0' align='center'>" +
	        	    "    <tr>" +
	        	    "      <td align='center'>" +
	        	    "        <table width='600' cellpadding='0' cellspacing='0' style='background-color: #EDE0D4; border-radius: 20px; padding: 40px;'>" +
	        	    "          <tr>" +
	        	    "            <td style='text-align: center; font-size: 28px; font-weight: bold; color: #5a3c28;'>Password Reset Request</td>" +
	        	    "          </tr>" +
	        	    "          <tr>" +
	        	    "            <td style='text-align: center; font-size: 16px; color: #5a3c28; padding: 20px 0;'>" +
	        	    "              You recently requested to reset your password.<br>" +
	        	    "              Please use the verification code below:" +
	        	    "            </td>" +
	        	    "          </tr>" +
	        	    "          <tr>" +
	        	    "            <td style='text-align: center; font-size: 30px; font-weight: bold; color: #7F5539; padding: 10px 0;'>" +
	        	                    code +
	        	    "            </td>" +
	        	    "          </tr>" +
	        	    "          <tr>" +
	        	    "            <td style='text-align: center; font-size: 12px; color: #5a3c28; padding-top: 20px;'>" +
	        	    "              <br>If you didn’t request this, please ignore this email." +
	        	    "            </td>" +
	        	    "          </tr>" +
	        	    "          <tr>" +
	        	    "            <td style='text-align: center; font-size: 14px; color: #5a3c28; padding-top: 20px;'>" +
	        	    "              <br>Reset your password <a href='http://localhost:4200/forgot-password' style='color: #5a3c28; text-decoration: underline;'>here</a>." +
	        	    "            </td>" +
	        	    "          </tr>" +
	        	    "        </table>" +
	        	    "      </td>" +
	        	    "    </tr>" +
	        	    "  </table>" +
	        	    "</body>" +
	        	    "</html>";

	    
	    		 emailService.sendCode(email,"Rest Password!", htmlBody);
	 	        Code_Account code_verif =new Code_Account(code);
	 	        codeRepository.save(code_verif);
	 	        account.setCode(code_verif);
	 	        accountRepository.save(account);
	 	        return account;
	    	}
	       return account;
	    }
	    
	    @PostMapping("verify-code/{email}")
	    public ResponseEntity<?> verifyCode(@PathVariable("email") String email,@RequestBody Code_Account code) {
	        System.out.println("providedCode "+code);
	    	Account account=accountService.GetAccountByEmail(email);
	        String storedCode = account.getCode().getCode();
	        String providedCode = code.getCode();
	    
	        System.out.println("storedCode.trim().equalsIgnoreCase(code.trim())"+ storedCode.equalsIgnoreCase(providedCode));
	        if (storedCode != null && storedCode.equalsIgnoreCase(providedCode)) {
	            return ResponseEntity.ok(account);
	        } else {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid verification code.");
	        }
	    }
	    @PutMapping("rest/Password/{email}")
	    public ResponseEntity<?> restpassword(@PathVariable("email") String email, @RequestBody Account account) {
	    	Account acc = accountService.GetAccountByEmail(email);
	    	System.out.println("get password"+account.getPsw());

	    	if(account.getPsw().equalsIgnoreCase(account.getConfirmationpsw())) {
		    	acc.setPsw(passwordEncoder.encode(account.getPsw()));
		    	acc.setConfirmationpsw(passwordEncoder.encode(account.getConfirmationpsw()));
		    	accountRepository.save(acc);
	    		 return ResponseEntity.ok(acc);}
	    	else {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("those passwords doesn't match, try again");
	        }
}

}
