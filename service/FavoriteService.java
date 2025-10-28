package com.deepinsta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepinsta.modal.Product;
import com.deepinsta.modal.Admin;
import com.deepinsta.modal.Favorite;
import com.deepinsta.modal.Users;
import com.deepinsta.repository.FavoriteRepository;

@Service
public class FavoriteService {
	@Autowired
	private FavoriteRepository favRepository;
	@Autowired
	private ProductService productService;
	@Autowired
	private UsersService userService;
	@Autowired
	private AdminService adminService;
	
	
	

	public Favorite addFavoriteByUser(long id_product, long id_user,Favorite favorite) {
		Product product=productService.GetProductById(id_product);
		Users user=userService.FindUserByID(id_user);
		Favorite fav =favRepository.FindByUserAndProduct(user, product);
		if(fav==null) {
			favorite.setProduct(product);
			favorite.setUser(user);
			favorite.setIsfav(true);
			favRepository.save(favorite);
				      
		}else {
			favRepository.delete(fav);
		}
		 return favorite;
	}
	public Favorite addFavoriteByAdmin(long id_product, long id_admin,Favorite favorite) {
		Product product=productService.GetProductById(id_product);
		Admin admin=adminService.findAdminById(id_admin);
		Favorite fav =favRepository.FindByAdminAndProduct(admin, product);
		if(fav==null) {
			favorite.setProduct(product);
			favorite.setAdmin(admin);
			favorite.setIsfav(true);
			favRepository.save(favorite);
				      
		}else {
			
			favRepository.delete(fav);
		}
		 return favorite;
	}
	public Favorite getFavoritebyUserandProduct(long id_user ,long id_product) {
		Product product=productService.GetProductById(id_product);
		Users user=userService.FindUserByID(id_user);
		Favorite star =favRepository.FindByUserAndProduct(user, product);
	    return star;
	}
	public Favorite getFavoritebyAdminandProduct(long id_admin ,long id_product) {
		Product product=productService.GetProductById(id_product);
		Admin admin=adminService.findAdminById(id_admin);
		Favorite star =favRepository.FindByAdminAndProduct(admin, product);
	    return star;
	}
	
	public List<Favorite> getFavoritesByProduct(long id_product) {
		Product product=productService.GetProductById(id_product);
		List<Favorite>fav =favRepository.FindByProduct(product);
	    return fav;
	}
	public List<Favorite> getFavoritesbyUser(long id_user) {
		Users user=userService.FindUserByID(id_user);
	    return favRepository.FindByUser(user);
	}
	public List<Favorite> getFavoritesbyAdmin(long id_admin) {
		Admin admin=adminService.findAdminById(id_admin);
	    return favRepository.FindByAdmin(admin);
	}
	

}
