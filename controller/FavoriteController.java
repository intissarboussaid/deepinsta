package com.deepinsta.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepinsta.modal.Favorite;
import com.deepinsta.modal.Rating;
import com.deepinsta.service.FavoriteService;

@RestController
@RequestMapping("api/deepshop/fav/")
public class FavoriteController {
	@Autowired
	private FavoriteService favService;
	
	@PostMapping("add/user/{id_product}/{id_user}")
	 public Favorite AddFavByUser(@PathVariable("id_product") long id_product, @PathVariable("id_user")  long id_user,@RequestBody Favorite favorite ) throws IOException {
	    return favService.addFavoriteByUser(id_product, id_user,favorite);
	    }
	@PostMapping("add/admin/{id_product}/{id_admin}")
	 public Favorite AddFavByAdmin(@PathVariable("id_product") long id_product, @PathVariable("id_admin")  long id_admin,@RequestBody Favorite favorite ) throws IOException {
	    return favService.addFavoriteByAdmin(id_product, id_admin,favorite);
	    }
	
	@GetMapping("get/product/{id_product}")
	 public List<Favorite> GetFavoriteByProduct(@PathVariable("id_product") long id_product) throws IOException {
	    return favService.getFavoritesByProduct(id_product);
	    }
	@GetMapping("get/user/{id_user}")
	 public List<Favorite> GetFavoriteUser(@PathVariable("id_user") long id_user) throws IOException {
	    return favService.getFavoritesbyUser(id_user);
	    }
	@GetMapping("get/admin/{id_admin}")
	 public List<Favorite> GetFavoriteByAdmin(@PathVariable("id_admin") long id_admin) throws IOException {
	    return favService.getFavoritesbyAdmin(id_admin);
	    }
	@GetMapping("Get/By/User/product/{id_user}/{id_product}")
	 public Favorite GetFavoriteByUserAndProduct(@PathVariable("id_user") long id_user,@PathVariable("id_product") long id_product) throws IOException {
	    return favService.getFavoritebyUserandProduct(id_user,id_product);
	    }
	@GetMapping("Get/By/admin/product/{id_admin}/{id_product}")
	 public Favorite GetFavoriteByAdminAndProduct(@PathVariable("id_admin") long id_admin,@PathVariable("id_product") long id_product) throws IOException {
	    return favService.getFavoritebyAdminandProduct(id_admin,id_product);
	    }


}
