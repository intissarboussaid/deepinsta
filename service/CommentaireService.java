package com.deepinsta.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepinsta.modal.Admin;
import com.deepinsta.modal.Commentaire;
import com.deepinsta.modal.Product;
import com.deepinsta.modal.Users;
import com.deepinsta.modal.ViewProduct;
import com.deepinsta.repository.CommentaireRepository;

@Service
public class CommentaireService {
	
	@Autowired
	ProductService productService;
	@Autowired
	UsersService userService;
	@Autowired
	AdminService adminService;
	@Autowired
	CommentaireRepository commentiareRepository;
	
	
	public Commentaire addCommentaire(long id_product, long id_user, Commentaire commentaire) {
		Product product=productService.GetProductById(id_product);
		Users user=userService.FindUserByID(id_user);
		commentaire.setProduct(product);
		commentaire.setUser(user);
		commentiareRepository.save(commentaire);
		List<Commentaire> commentaires=commentiareRepository.findByProduct(product);
	       int totalCommentaires = commentaires.size(); // Count the number 
	       commentaire.setNbre(totalCommentaires);
	    return commentaire;
	}
	public Commentaire addCommentaireByAdmin(long id_product, long id_admin, Commentaire commentaire) {
		Product product=productService.GetProductById(id_product);
		Admin admin=adminService.findAdminById(id_admin);
		commentaire.setProduct(product);
		commentaire.setAdmin(admin);
		commentiareRepository.save(commentaire);
		List<Commentaire> commentaires=commentiareRepository.findByProduct(product);
	       int totalCommentaires = commentaires.size(); // Count the number 
	       commentaire.setNbre(totalCommentaires);
	    return commentaire;
	}
	
	public List<Commentaire> getCommentairebyProduct(long id_product) {
		Product product=productService.GetProductById(id_product);
		List<Commentaire> commentaires=commentiareRepository.findByProduct(product);
	    return commentaires;
	}
	public List<Commentaire> getCommentairebyUser(long id_user) {
		Users user=userService.FindUserByID(id_user);
		List<Commentaire> commentaires=commentiareRepository.findByUser(user);
	    return commentaires;
	}
	public List<Commentaire> getCommentairebyAdmin(long id_admin) {
		Admin admin=adminService.findAdminById(id_admin);
		List<Commentaire> commentaires=commentiareRepository.findByAdmin(admin);
	    return commentaires;
	}
	public List<Commentaire> getAllCommentairesToAdmin(long id_admin) {
		List<Product>products=productService.GetProductsByAdmin(id_admin);
		List<Commentaire >commentaires=new ArrayList<>();
		for(Product product: products) {
			commentaires.addAll(getCommentairebyProduct(product.getId_product()));
		}		
	    return commentaires;
	}

}
