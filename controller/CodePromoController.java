package com.deepinsta.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepinsta.modal.CodePromo;
import com.deepinsta.modal.Commande;
import com.deepinsta.service.CodePromoService;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/deepshop/codePromo/")
@RequiredArgsConstructor
public class CodePromoController {
	@Autowired
	CodePromoService codePromoService;
	
	@PostMapping("add/user/{id_admin}/{id_user}")
	 public CodePromo AddFavByUser(@PathVariable("id_admin") long id_admin, @PathVariable("id_user")  long id_user,@RequestBody CodePromo codePromo ) throws IOException {
	    return codePromoService.addCodePromo(id_admin, id_user,codePromo);
	    }
	
	@GetMapping("get/promo/admin/user/{id_admin}/{id_user}")
	 public CodePromo getByAdminAndUser(@PathVariable("id_admin") long id_admin,@PathVariable("id_user") long id_user ) throws IOException, MessagingException {
	    return codePromoService.getByAdminAndUser(id_admin,id_user);
	    }
	
	@GetMapping("send/code/{id_cmd}/{name}")
	 public Commande SendCodePromo( @PathVariable("id_cmd")long id_cmd,@PathVariable("name")String name) throws IOException {
		System.out.println("test code promo: "+name);
		System.out.println("test id commande: "+id_cmd );
	    return codePromoService.SendPromoCode(id_cmd,name);
	    }

}
