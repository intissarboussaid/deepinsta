package com.deepinsta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.deepinsta.modal.Rating;
import com.deepinsta.modal.Admin;
import com.deepinsta.modal.Commentaire;
import com.deepinsta.modal.Product;
import com.deepinsta.modal.Users;
import com.deepinsta.repository.RatingRepository;
import com.deepinsta.repository.ProductRepository;
import com.deepinsta.repository.UsersRepository;

import lombok.RequiredArgsConstructor;


@Service
public class RatingService {
	@Autowired
	private RatingRepository ratingRepository;
	@Autowired
	private ProductService productService;
	@Autowired
	private UsersService userService;
	@Autowired
	private AdminService adminService;
	

	public Rating getRatingbyUserandProduct(long id_user ,long id_product) {
		Product product=productService.GetProductById(id_product);
		Users user=userService.FindUserByID(id_user);
		Rating star =ratingRepository.FindByUserAndProduct(user, product);
	    return star;
	}
	public Rating getRatingbyAdminandProduct(long id_admin ,long id_product) {
		Product product=productService.GetProductById(id_product);
		Admin admin=adminService.findAdminById(id_admin);
		Rating star =ratingRepository.FindByAdminAndProduct(admin, product);
	    return star;
	}
	public Rating addRating(long id_product, long id_user, Rating rating) {
		Product product=productService.GetProductById(id_product);
		Users user=userService.FindUserByID(id_user);
		Rating star =ratingRepository.FindByUserAndProduct(user, product);
		if(star!=null) {
			star.setStarts(rating.getStarts());
			ratingRepository.save(star);
			double sommeStarts=0;
			List<Rating> ratings=ratingRepository.FindByProduct(product);
		       for(Rating starts :ratings) {
		    	   sommeStarts+= starts.getStarts();
		    	   System.out.println("rating: "+starts.getStarts()	);
		       }
		       product.setRating(sommeStarts/ratings.size());
		       System.out.println("rating: "+product.getRating()+ "total Ratings: "+sommeStarts);
		       productService.saveProduct(product);	
		       return star;
		}else {
			rating.setProduct(product);
			rating.setUser(user);
			rating.setStarts(rating.getStarts());
			ratingRepository.save(rating);
			double sommeStarts=0;
			List<Rating> ratings=ratingRepository.FindByProduct(product);
		       for(Rating starts :ratings) {
		    	   sommeStarts+= starts.getStarts();
		    	   System.out.println("rating: "+starts.getStarts()	);
		       }
		       product.setRating(sommeStarts/ratings.size());
		       System.out.println("rating: "+product.getRating()+ "total Ratings: "+sommeStarts);
		       productService.saveProduct(product);	
		       return rating;
		}

	       
	   // return rating;
	}
	
	public Rating addRatingByAdmin(long id_product, long id_admin, Rating rating) {
		Product product=productService.GetProductById(id_product);
		Admin admin=adminService.findAdminById(id_admin);
		Rating star =ratingRepository.FindByAdminAndProduct(admin, product);
		if(star!=null) {
			star.setStarts(rating.getStarts());
			ratingRepository.save(star);
			double sommeStarts=0;
			List<Rating> ratings=ratingRepository.FindByProduct(product);
		       for(Rating starts :ratings) {
		    	   sommeStarts+= starts.getStarts();
		    	   System.out.println("rating: "+starts.getStarts()	);
		       }
		       product.setRating(sommeStarts/ratings.size());
		       System.out.println("rating: "+product.getRating()+ "total Ratings: "+sommeStarts);
		       productService.saveProduct(product);	
		       return star;
		}else {
			rating.setProduct(product);
			rating.setAdmin(admin);
			rating.setStarts(rating.getStarts());
			ratingRepository.save(rating);
			double sommeStarts=0;
			List<Rating> ratings=ratingRepository.FindByProduct(product);
		       for(Rating starts :ratings) {
		    	   sommeStarts+= starts.getStarts();
		    	   System.out.println("rating: "+starts.getStarts()	);
		       }
		       product.setRating(sommeStarts/ratings.size());
		       System.out.println("rating: "+product.getRating()+ "total Ratings: "+sommeStarts);
		       productService.saveProduct(product);	
		       return rating;
		}

	       
	   // return rating;
	}
	public List<Rating> getRatingsByProduct(long id_product) {
		Product product=productService.GetProductById(id_product);
		List<Rating>rating =ratingRepository.FindByProduct(product);
	    return rating;
	}
	public List<Rating> getRatingbyUser(long id_user) {
		Users user=userService.FindUserByID(id_user);
	    return ratingRepository.FindByUser(user);
	}
	
	public List<Rating> getRatingbyAdmin(long id_admin) {
		Admin admin=adminService.findAdminById(id_admin);
	    return ratingRepository.FindByAdmin(admin);
	}
	public List<Rating> getRatingbyProductandStarts(long id_product ,Double starts) {
		Product product=productService.GetProductById(id_product);
		List<Rating> star =ratingRepository.FindBystarts(starts, product);
	    return star;
	}
	
	

}
