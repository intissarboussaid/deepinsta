package com.deepinsta.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepinsta.modal.Commentaire;
import com.deepinsta.modal.Rating;
import com.deepinsta.service.RatingService;




@RestController
@RequestMapping("api/deepinsta/rating/")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping("add/{id_product}/{id_user}")
	 public Rating AddRating(@PathVariable("id_product") long id_product, @PathVariable("id_user")  long id_user,@RequestBody Rating rating ) throws IOException {
	    return ratingService.addRating(id_product, id_user, rating);
	    }
	@PostMapping("add/by/admin/{id_product}/{id_admin}")
	 public Rating AddRatingByAdmin(@PathVariable("id_product") long id_product, @PathVariable("id_admin")  long id_admin,@RequestBody Rating rating ) throws IOException {
	    return ratingService.addRatingByAdmin(id_product, id_admin, rating);
	    }
	
	@GetMapping("get/product/{id_product}")
	 public List<Rating> GetRatingByProduct(@PathVariable("id_product") long id_product) throws IOException {
	    return ratingService.getRatingsByProduct(id_product);
	    }
	@GetMapping("get/admin/{id_admin}")
	 public List<Rating> GetRatingAdmin(@PathVariable("id_admin") long id_admin) throws IOException {
	    return ratingService.getRatingbyAdmin(id_admin);
	    }
	@GetMapping("get/user/{id_user}")
	 public List<Rating> GetRatingUser(@PathVariable("id_user") long id_user) throws IOException {
	    return ratingService.getRatingbyUser(id_user);
	    }
	@GetMapping("Get/By/User/product/{id_user}/{id_product}")
	 public Rating getByUserAndProduct(@PathVariable("id_user") long id_user, @PathVariable("id_product")  long id_product ) throws IOException {
	    return ratingService.getRatingbyUserandProduct(id_user, id_product);
	    }
	@GetMapping("Get/By/admin/product/{id_admin}/{id_product}")
	 public Rating getByAdminAndProduct(@PathVariable("id_admin") long id_admin, @PathVariable("id_product")  long id_product ) throws IOException {
	    return ratingService.getRatingbyAdminandProduct(id_admin, id_product);
	    }
	@GetMapping("Get/By/starts/{id_product}/{starts}")
	 public List<Rating> getBySarts(@PathVariable("starts") Double starts, @PathVariable("id_product")  long id_product ) throws IOException {
	    return ratingService.getRatingbyProductandStarts(id_product, starts);
	    }
	

}
