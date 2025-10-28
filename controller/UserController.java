package com.deepinsta.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.deepinsta.modal.Photo;
import com.deepinsta.modal.Product_manager;
import com.deepinsta.modal.Users;
import com.deepinsta.service.UsersService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/deepinsta/user/")
@RequiredArgsConstructor
public class UserController {
	
	@Autowired
	UsersService userService;
	
	
	//find
	@GetMapping("{id_user}")
	 public Users GetUser(@PathVariable("id_user") long id_user)  {
    	return userService.FindUserByID(id_user);
    }
	
	  @PutMapping("update/photo/{id_user}")
	    public Users UpdatePhotoUser(@PathVariable("id_user") long id_user, @RequestParam(name = "file") MultipartFile file) throws IOException {
	    	System.out.println("test");
	    	Users user = userService.updatePhoto(id_user, file);
	    	return user;
	    }
	  
		
		 @PutMapping("update/All/Informations/{id_user}")
		    public Users AddInformations(@PathVariable("id_user") long id_user,@RequestBody Users usersRequest) throws IOException {
		    	 Users user = userService.updateUser(id_user, usersRequest);
		    	return user;
		    }
	  @GetMapping("photo/{id_user}")
		public ResponseEntity<?> getPhoto(@PathVariable("id_user") long id_user) throws IOException {
		  return userService.getPhoto(id_user);
		}

}
