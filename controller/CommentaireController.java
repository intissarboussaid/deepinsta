package com.deepinsta.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepinsta.modal.AuthenticationRequest;
import com.deepinsta.modal.Commentaire;
import com.deepinsta.service.CommentaireService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/deepinsta/commentaire/")
@RequiredArgsConstructor
public class CommentaireController {
	
	@Autowired
	CommentaireService commentaireService;
	
	@PostMapping("add/by/user/{id_product}/{id_user}")
	 public Commentaire AddCommentaire(@PathVariable("id_product") long id_product, @PathVariable("id_user")  long id_user,@RequestBody Commentaire commentaire ) throws IOException {
	    return commentaireService.addCommentaire(id_product, id_user, commentaire);
	    }
	@PostMapping("add/by/admin/{id_product}/{id_admin}")
	 public Commentaire AddCommentaireByAdmin(@PathVariable("id_product") long id_product, @PathVariable("id_admin")  long id_admin,@RequestBody Commentaire commentaire ) throws IOException {
	    return commentaireService.addCommentaireByAdmin(id_product, id_admin, commentaire);
	    }
	@GetMapping("get/product/{id_product}")
	 public List<Commentaire> GetCommentaireByProduct(@PathVariable("id_product") long id_product) throws IOException {
	    return commentaireService.getCommentairebyProduct(id_product);
	    }
	
	@GetMapping("get/user/{id_user}")
	 public List<Commentaire> GetCommentaireByUser(@PathVariable("id_user") long id_user) throws IOException {
	    return commentaireService.getCommentairebyUser(id_user);
	    }
	@GetMapping("get/admin/{id_admin}")
	 public List<Commentaire> GetCommentaireByAdmin(@PathVariable("id_admin") long id_admin) throws IOException {
	    return commentaireService.getCommentairebyAdmin(id_admin);
	    }
	@GetMapping("get/admin/commentaires/{id_admin}")
	 public List<Commentaire> GetCommentaireToAdmin(@PathVariable("id_admin") long id_admin) throws IOException {
	    return commentaireService.getAllCommentairesToAdmin(id_admin);
	    }

}
